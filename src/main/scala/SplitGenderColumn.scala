import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions._

object SplitGenderColumn {

  def main(args: Array[String]): Unit = {

    val spark = SparkSession.builder().appName("SplitGenderColumn").master("local[*]").getOrCreate()

    spark.sparkContext.setLogLevel("ERROR")

    import spark.implicits._

    val l = List("M","M","M","M","F","F","F","F")

    val rdd = spark.sparkContext.parallelize(l)

    val df = rdd.toDF("Gender")

    //df.createOrReplaceTempView("g_table")

    //spark.sql("select Gender from (select Gender, row_number() over(partition by rank order by rank) as row from (select Gender, dense_rank() over(order by Gender) as rank from g_table) order by row)").show()


    val win1 = Window.orderBy("Gender")
    val rank = dense_rank().over(win1)

    val win = Window.partitionBy("rank").orderBy("rank")
    val row = row_number().over(win)

    df.select($"*",rank as "rank").orderBy($"rank").select($"*", row as "row").orderBy($"row").select($"Gender").show()
  }

}
