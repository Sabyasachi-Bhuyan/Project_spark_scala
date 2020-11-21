import org.apache.spark.sql.SparkSession

object SchemaCompare {

  def main(args: Array[String]): Unit = {


    val spark = SparkSession.builder().appName("SchemaCompare").master("local[*]").getOrCreate()

    val test_df = spark.read.format("csv").option("header","true").load("C:\\Users\\sabya\\Desktop\\Data Sets\\Test.csv")

    test_df.schema == test_df.schema
  }

}
