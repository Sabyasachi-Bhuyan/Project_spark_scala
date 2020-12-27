import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object MultipleDFJoin {

  def main(args: Array[String]): Unit = {

    val spark = SparkSession.builder().appName("MultipleDFJoin").master("local[*]").getOrCreate()
    val sc = spark.sparkContext

    sc.setLogLevel("ERROR")

    import spark.implicits._

    val df1 = sc.parallelize(Seq(
      (1,null,null,null,null),
      (2,"A2","A21",null, "A41"))
    ).toDF("id", "val1", "val2", "val3", "val4")

    val df2 = sc.parallelize(Seq(
      (1,"B1","B21","B31", "B41"),
      (2,null,null,null,null))
    ).toDF("id", "val1", "val2", "val3", "val4")

    val df3 = sc.parallelize(Seq(
      (1,"C1","C2","C3","C4"),
      (2,"C11","C12","C13", "C14"))
    ).toDF("id", "val1", "val2", "val3", "val4")

    df1.show()
    df2.show()
    df3.show()

    val consolidated = df1.join(df2, "id").join(df3, "id").select(
      df1("id"),
      coalesce(df1("val1"), df2("val1"), df3("val1")).as("finalVal1"),
      coalesce(df1("val2"), df2("val2"), df3("val2")).as("finalVal2"),
      coalesce(df1("val3"), df2("val3"), df3("val3")).as("finalVal3"),
      coalesce(df1("val4"), df2("val4"), df3("val4")).as("finalVal4")
    )
    consolidated.show()

  }

}
