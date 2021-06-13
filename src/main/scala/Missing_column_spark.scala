import org.apache.spark.sql.types.StructType
import org.apache.spark.sql.{DataFrame, SparkSession, types}
import org.apache.spark.sql.functions._

object Missing_column_spark {


    def main(args: Array[String]): Unit = {

      val spark = SparkSession.builder().master("local[*]").appName("Missing_column_spark").getOrCreate()
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

      val columns_1 = df.columns.toSet
      val columns_2 = df1.columns.toSet
      println(columns_1)
      println(columns_2)

      val missing_col = (columns_1 -- columns_2).toList
      println(columns_1 -- columns_2)
      println(missing_col)

      val columns_1_1= df.columns
      val results = missing_col.foldLeft(df1){(df1,i) =>
        df1.withColumn(i,lit("null"))}.select(columns_1_1.head,columns_1_1.tail: _*)

      println("results data frame")
      results.show()


      //println("df data frame with df1 data frame union")
      //df.union(df1).show()
      println("df data frame with results data frame union")
      val df_x=df.union(results)

      df_x.show()

      //columns_1.foreach(println)

      //df_x.select($"*",concat(substring($"Name",1,1),$"hight").as("alias")).show()


    }


}
