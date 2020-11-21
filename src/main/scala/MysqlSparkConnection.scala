import org.apache.spark.sql.SparkSession

object MysqlSparkConnection {

  def main(args: Array[String]): Unit = {

    val spark = SparkSession.builder().appName("MysqlSparkConnection").master("local[*]").getOrCreate()
    val sc = spark.sparkContext

    sc.setLogLevel("ERROR")

    val mysql_df = spark.read.format("jdbc").option("url", "jdbc:mysql://localhost:3306/") //*****This is the database name
      //.option("driver","com.mysql.jdbc.Driver")
      .option("dbtable","sakila.actor")//***** is the table name
      .option("user","root").option("password","1234").load()

    mysql_df.show()
    mysql_df.write.format("csv").option("header","true").save("C:\\Users\\sabya\\Desktop\\Data Sets\\mysql_test")

  }

}
