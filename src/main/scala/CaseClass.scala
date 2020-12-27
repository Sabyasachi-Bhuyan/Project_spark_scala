import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.{Dataset, SparkSession}

case class SchemaClass(No:String,Name:String,hight:String,weight:String)

object CaseClass {

  def main(args: Array[String]): Unit = {

    Logger.getLogger("org").setLevel(Level.ERROR)
    val spark = SparkSession.builder.appName("CaseClass").master("local[*]").getOrCreate()
    import spark.implicits._
    val sc = spark.sparkContext

    val df = spark.read.csv("C:\\Users\\sabya\\Desktop\\Data Sets\\Test2.csv")

    df.as[SchemaClass].show()


  }

}
