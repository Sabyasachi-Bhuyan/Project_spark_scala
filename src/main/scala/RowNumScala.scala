import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions._

object RowNumScala {

  def main(args: Array[String]): Unit = {

    val spark = SparkSession.builder().appName("RowNumScala").master("local[*]").getOrCreate()

    import spark.implicits._

    val sc = spark.sparkContext

    sc.setLogLevel("ERROR")

    val df = spark.read.format("csv").option("header","true").load("C:\\Users\\sabya\\Desktop\\Data Sets\\Test3.csv")

    val win = Window.orderBy($"No")
    val win_row = row_number().over(win)

    df.select($"*",win_row as "win_row").where($"win_row"%2 ===1).show()


  }

}

