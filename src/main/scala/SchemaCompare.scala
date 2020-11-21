import org.apache.spark.sql.SparkSession

object SchemaCompare {

  def main(args: Array[String]): Unit = {


    val spark = SparkSession.builder().appName("SchemaCompare").master("local[*]").getOrCreate()
    spark.sparkContext.setLogLevel("ERROR")

    val df1 = spark.read.format("csv").option("header","true").load("C:\\Users\\sabya\\Desktop\\Data Sets\\Test.csv")
    val df2 = spark.read.format("csv").option("header","true").load("C:\\Users\\sabya\\Desktop\\Data Sets\\Test3.csv")

    //test_df.show()
    //test3_df.show()

    val s1 = df1.schema.fields.map(f => (f.name, f.nullable))
    println("=========== DF1 Schema =============")
    s1.foreach(println)

    val s2 = df2.schema.fields.map(f => (f.name, f.nullable))
    println("=========== DF2 Schema =============")
    s2.foreach(println)

    println("=========== Start Compare ==========")
    //Then you can just make use of the diff method from Lists, which will return the differences,
    // if that method returns and empty list, then there is no difference, otherwise it will return false.
    val compare1 = s1.diff(s2).isEmpty
    println("compare1 :: "+compare1)

    //Consider that the diff method returns no difference when a field is present in one list but not in the other one.
    // So you may need to attach a second condition to compare lengths.
    val compare2 = s1.diff(s2).isEmpty && s1.length == s2.length
    println("compare2 :: "+compare2)
  }

}
