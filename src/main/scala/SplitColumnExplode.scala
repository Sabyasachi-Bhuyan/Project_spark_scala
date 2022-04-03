import org.apache.spark.sql.{Column, SparkSession}
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._

object SplitColumnExplode {

  def main(args: Array[String]): Unit = {

    val spark = SparkSession.builder().appName("SplitColumnFlatMap").master("local[*]").getOrCreate()
    spark.sparkContext.setLogLevel("ERROR")

    val data = Seq(("1","bread","water|salt|fine wheat"),("2","sharbat","boiled_water|sugar"),("3","dhokla","water|salt|suji"),("4","sandwich","bread|butter|vegetable"))
    import  spark.sqlContext.implicits._
    //DF
    val df = data.toDF("dish_id","dish","recepies")
    df.show()
    df.withColumn("recepies", explode(split($"recepies","\\|"))).show()


  }

}
