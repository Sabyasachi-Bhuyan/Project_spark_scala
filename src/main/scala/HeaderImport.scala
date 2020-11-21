import org.apache.spark.sql.SparkSession

object HeaderImport {

  def main(args: Array[String]): Unit = {

    val spark = SparkSession.builder().appName("HeaderImport").master("local[*]").getOrCreate()
    val sc = spark.sparkContext
    sc.setLogLevel("ERROR")

    val header = spark.read.format("csv").option("header","true").load("C:\\Users\\sabya\\Desktop\\Data Sets\\Test2_header.csv")
    val file = spark.read.format("csv").load("C:\\Users\\sabya\\Desktop\\Data Sets\\Test2.csv")

    val columns = header.columns
    println("==========columns=============")
    println(columns)
    println("==========file without header============")
    file.show()
    println("==========file with header============")
    file.toDF(columns:_*).show()



  }

}
