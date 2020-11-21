import org.apache.spark.sql.{Column, SparkSession}
import org.apache.spark.sql.types._
import org.apache.spark.sql.functions._

object SplitSingleColumn {

  def main(args: Array[String]): Unit = {

    val data = Seq(("James, A, Smith","2018","M",3000),("Maria, Anne, Jones","2005","M",4000),("Michael, Rose, Jones","2010","F",1500),("Jen, Mary, Brown","2010","",-1))

    val spark = SparkSession.builder().appName("SplitSingleColumn").master("local[*]").getOrCreate()
    val sc = spark.sparkContext
    sc.setLogLevel("ERROR")

    import  spark.sqlContext.implicits._

    val df = data.toDF("name","dob_year","gender","salary")

    df.show()

    val df_split = df.withColumn("name", split($"name",","))
      .select($"name".getItem(0).as("First Name"),$"name".getItem(1).as("Middle Name")
        ,$"name".getItem(2).as("Last Name"),$"dob_year",$"gender",$"salary")

    //val df_join = df.join( df_split, df("dob_year") === df_split("dob_year"), "inner" )
    val df1 = df_split.withColumn("gender1",regexp_replace($"gender","\\s+", null))

    //null value convert to other string
    //df1.na.fill("0").show()
    df1.show()

    //Data manupulation using 'withColumn'
    df1.withColumn("salary", df1("salary")+1).show()


  }

}
