import org.apache.spark.sql.{DataFrame, SparkSession}

object Schema_drifting {

  def main(args: Array[String]): Unit = {

    val spark = SparkSession.builder().master("local[*]").appName("Schema_drifting").getOrCreate()
    spark.sparkContext.setLogLevel("ERROR")
    import spark.implicits._

    val df = spark.read.format("csv").option("header","true").option("inferSchema","true")
      .load("C:\\Users\\sabya\\Desktop\\Data Sets\\Schema_drifting\\Test3_av.csv")
    val df1 = spark.read.format("csv").option("header","true").option("inferSchema","true")
      .load("C:\\Users\\sabya\\Desktop\\Data Sets\\Schema_drifting\\Test3_alt.csv")

    println("df data frame with av data")
    df.show()
    println("df1 data frame with alt data")
    df1.show()

    //val columns_1: Array[String] = df.columns
    val columns_1 = df.columns

    //val reorderColumnNames: Array[String] = columns_1
    //val results: DataFrame = df1.select(reorderColumnNames.head,reorderColumnNames.tail: _*) //only column changed but data in same place

    //val results: DataFrame = df1.select(columns_1.head,columns_1.tail: _*)
    val results = df1.select(columns_1.head,columns_1.tail: _*)

    println("results data frame")
    results.show()

    //println("df data frame with df1 data frame union")
    //df.union(df1).show()
    println("df data frame with results data frame union")
    df.union(results).show()

    columns_1.foreach(println)


  }

}
