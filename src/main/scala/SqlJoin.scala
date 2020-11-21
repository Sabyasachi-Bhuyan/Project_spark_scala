import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types._
import org.apache.spark.sql.functions._

object SqlJoin {

  def main(args: Array[String]): Unit = {

    val spark = SparkSession.builder().appName("SqlJoin").master("local[*]").getOrCreate()

    spark.sparkContext.setLogLevel("ERROR")

    val list1 = List((1,1,1),(1,1,1),(1,1,1))
    val list2 = List((1,1),(1,1),(1,1))

    val list1_rdd = spark.sparkContext.parallelize(list1)
    val list2_rdd = spark.sparkContext.parallelize(list2)

    //val data_schema = StructType(StructField("col1",IntegerType,true) :: StructField("col2",IntegerType,true) :: StructField("col3",IntegerType,true) :: Nil)

    //val df1 = spark.createDataFrame(list1_rdd, data_schema)
    val df1 = spark.createDataFrame(list1_rdd).toDF("col1","col2","col3")
    val df1_1 = spark.createDataFrame(list2_rdd).toDF("col1","col2")

    val df2 = df1
    val df2_1 = df1_1


    df1.show()
    df1_1.show()
    df2.show()
    df2_1.show()

    //Inner Join

    val inner_join = df1.join(df2, df1("col1") === df2("col1"))
    val inner_join_1 = df1_1.join(df2_1, df1_1("col1") === df2_1("col1")).show()

    //Left Outer Join
    //val full_join = df1.join(df2, df1("col1") === df2("col1"), "full").show()
    //val left_join_1 = df1_1.join(df2_1, df1_1("col1") === df2_1("col1"),"left").show()

    //inner_join.write.saveAsTable()



  }

}
