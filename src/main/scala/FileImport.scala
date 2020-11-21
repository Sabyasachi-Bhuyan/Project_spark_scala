import org.apache.spark.sql.SparkSession

object FileImport {

  def main(args: Array[String]): Unit = {

    val spark = SparkSession.builder().appName("FileImport").master("local[*]").getOrCreate()
    val sc = spark.sparkContext

    sc.setLogLevel("ERROR")

    val multiRdd = sc.textFile("C:\\Users\\sabya\\Desktop\\Data Sets\\Test.csv,C:\\Users\\sabya\\Desktop\\Data Sets\\Test2.csv")
    val flat = multiRdd.flatMap(x => x.split(',')).map(x=>(x,1)).reduceByKey(_+_)
    //flat.saveAsTextFile("C:\\Users\\sabya\\Desktop\\Data Sets\\abc")
    //flat.foreach(println)

    val multiDF = spark.read.option("header", "true").csv("C:\\Users\\sabya\\Desktop\\Data Sets\\Test.csv","C:\\Users\\sabya\\Desktop\\Data Sets\\Test2.csv")
    multiDF.show()

    multiDF.select("No","height1").show()

  }

}
