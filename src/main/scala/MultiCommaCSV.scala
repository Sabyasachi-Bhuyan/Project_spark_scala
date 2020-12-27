import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object MultiCommaCSV {

  def main(args: Array[String]): Unit = {

    Logger.getLogger("org").setLevel(Level.ERROR)
    val spark = SparkSession.builder().appName("MultiCommaCSV").master("local[*]").getOrCreate()

    import spark.sqlContext.implicits._

    val df = spark.read.format("csv").option("header","true").load("C:\\Users\\sabya\\Desktop\\Data Sets\\Test_multi_comma.csv")

    val df_split = df.withColumn("address",split($"address",","))
      .select($"*",$"address".getItem(0).as("city"),$"address".getItem(1).as("district"))
      .drop('address)
      .show()
    val df2 = spark.read.format("csv").option("header","true").load("C:\\Users\\sabya\\Desktop\\Data Sets\\Test_multi_comma.csv")
    df2
    df2.show()


  }
}
