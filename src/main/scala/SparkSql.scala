import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object SparkSql {

  def main(args: Array[String]): Unit = {

    val spark = SparkSession.builder().appName("SparkSql").master("local[*]").getOrCreate()
    spark.sparkContext.setLogLevel("ERROR")

    
    val df = spark.read.option("InferSchema", "true").option("header", "true").csv("C:\\Users\\sabya\\Desktop\\Test.csv")
    //val df = spark.read.option("InferSchema", "true").option("header", "true").csv("TEST")
    //df.show()
    //df.withColumn("abc",lit(null:String)).show()

    //df.createGlobalTempView("test_view")
    //val staticSchema=df.schema
    //print(staticSchema)
    //df.selectExpr("weight","()")

    val df_sort = df.groupBy("weight").count.withColumnRenamed("count", "total")
      .sort(desc("total")).limit(2)
    df_sort.show()

    //println(amazonS3Client.listBuckets())



  }
}
