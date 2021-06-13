import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object Substring_concat {

  def main(args: Array[String]): Unit = {

    val spark = SparkSession.builder().master("local[*]").appName("Substring_concat").getOrCreate()

    spark.sparkContext.setLogLevel("ERROR")

    import spark.implicits._

    val data = Seq(("Raj","Kumar",30),("Saroj","Singh",40))

    val df = data.toDF("First_name","Last_name","age")

    df.withColumn("alias", concat(substring($"First_name",1,1),$"Last_name")).show()
    df.printSchema()
  }

}
