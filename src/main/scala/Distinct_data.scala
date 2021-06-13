import org.apache.spark.sql.SparkSession

object Distinct_data {

  def main(args: Array[String]): Unit = {


    val spark = SparkSession.builder().master("local[*]").appName("Distinct_data").getOrCreate()

    spark.sparkContext.setLogLevel("ERROR")

    import spark.implicits._

    val data = Seq((123,"Ram","Delhi"),(124,"Hari","Mumbai"),(125,"Sam","Delhi"),(126,"Ravi","Delhi"),(123,"Ram","Delhi"))

    val df = data.toDF("id","Name","loc")

    df.distinct().groupBy($"loc").count().withColumnRenamed("count","customer_count")
      .write.option("compression","gzip").format("parquet").mode("overwrite")
      .save("C:\\Users\\sabya\\Desktop\\Data Sets\\Distinct_data")
  }

}
