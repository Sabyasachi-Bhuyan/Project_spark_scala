import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._

object RowNumScala {

  def main(args: Array[String]): Unit = {

    val spark = SparkSession.builder().appName("RowNumScala").master("local[*]").getOrCreate()

    import spark.implicits._

    val sc = spark.sparkContext

    sc.setLogLevel("ERROR")

    val df = spark.read.format("csv").option("header","true").load("C:\\Users\\sabya\\Desktop\\Data Sets\\Test3.csv")

    val win = Window.orderBy($"No")
    val win_row = row_number().over(win)

    val df1 = df.withColumn("abc",$"No".cast(IntegerType)).select($"*",win_row as "win_row")
    df1.show()
    df1.filter("win_row in (1,3,7,6)").show()
    //df1.where($"win_row"%2 ===1).show()
    df1.printSchema()
    df1.withColumn("feet",split($"hight","\\.")(0)).withColumn("inch",split($"hight","\\.")(1)).show()


  }

}

