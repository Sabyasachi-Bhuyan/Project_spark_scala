import org.apache.spark.sql.SparkSession

object WordCount {

  def main(args: Array[String]): Unit = {

    val spark = SparkSession.builder().appName("WordCount").master("local[*]").getOrCreate()

    val sc=spark.sparkContext
    sc.setLogLevel("ERROR")

    val file = sc.textFile("C:\\Users\\sabya\\Desktop\\Data Sets\\Test2.csv")


      val word_count = file.flatMap(line => line.split(","))//.filter("chang" == _)
        .map(word => (word, 1)).reduceByKey(_ + _).filter(x=> x._2 == 1)

      word_count.foreach(println)

    println(word_count.count)

  }
}
