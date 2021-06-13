import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object EmpSQL {

  def main(args: Array[String]): Unit = {

    val spark = SparkSession.builder().appName("EmpSQL").master("local[*]").getOrCreate()
    val sc = spark.sparkContext
    sc.setLogLevel("ERROR")

    import spark.implicits._

    val emp_df = spark.read.format("csv").option("header","true").load("C:\\Users\\sabya\\Desktop\\Data Sets\\emp.csv")
    val dept_df = spark.read.format("csv").option("header","true").load("C:\\Users\\sabya\\Desktop\\Data Sets\\dept.csv")

    emp_df.createOrReplaceTempView("emp")
    dept_df.createOrReplaceTempView("dept")

    //val inner_join = emp_df.join(dept_df, emp_df("dep_id") === dept_df("id"),"inner")

    //inner_join.show()

    //sql anti join
    //=============
    //(Anti-joins are written using the NOT EXISTS or NOT IN constructs.)

    spark.sql("select * from dept where not exists(select 1 from emp where emp.dep_id = dept.id) order by dept.id").show()
    //spark.sql("select * from emp natural join dept").show()



  }

}
