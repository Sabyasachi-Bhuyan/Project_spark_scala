import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object NestedJson {

  def main(args: Array[String]): Unit = {


    val spark = SparkSession.builder().appName("NestedJson").master("local[*]").getOrCreate()
    spark.sparkContext.setLogLevel("ERROR")

    import spark.implicits._

    //val df = spark.read.format("json").load("C:\\Users\\sabya\\Desktop\\Data Sets\\nestedjson.json")
    val df_2 = spark.read.format("json").load("C:\\Users\\sabya\\Desktop\\Data Sets\\nestedjson2.json")

    //df.show(false)
    df_2.show(false)

    //nestedjson2.json file
    df_2.withColumn("lang", explode($"lang")).withColumn("id", $"lang"(0))
      .withColumn("langs", $"lang"(1)).withColumn("type",$"lang"(2)).drop($"lang").show()

    //nestedjson.json file
    //val df1 = df.withColumn("Address", explode($"Address")).select($"Address.*",$"Age",$"Name")
    //df1.show()


  }

}
