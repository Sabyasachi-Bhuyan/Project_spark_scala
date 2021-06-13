import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object Sample_alert_data_handle {

  def main(args: Array[String]): Unit = {

    val spark = SparkSession.builder().master("local[*]").appName("Sample_alert_data_handle").getOrCreate()
    val sc = spark.sparkContext
    sc.setLogLevel("ERROR")
    import spark.implicits._

    val df = sc.textFile("C:\\Users\\sabya\\Desktop\\Data Sets\\ALERT DATA.txt")

    val count1 = df.count()
    println(count1)
    val dropHeaderFooter = df.take(count1.toInt).drop(1).dropRight(1)
    val df1 = sc.parallelize(dropHeaderFooter)
    val df2 = df1.toDF

    val df3 = df2.withColumn("value", regexp_replace(df2.col("value"),"^\\|",""))
    val df4 = df3.withColumn("value", split($"value","\\|"))
    df4.show()
    val df5 = df4.select($"value".getItem(0).as("ALERT_ID"),
        $"value".getItem(1).as("ALERT_DATE"),
        $"value".getItem(2).as("SCORE"),
        $"value".getItem(3).as("P11"),
        $"value".getItem(4).as("P32"),
        $"value".getItem(5).as("entity_id"))
    df5.show()
    val skipable_first_row = df5.first()
    val df_final = df5.filter(row => row != skipable_first_row)
    df_final.show()
    //df_final.withColumn("AlERT_DATE",$"AlERT_DATE".cast("date")).show()



  }

}

