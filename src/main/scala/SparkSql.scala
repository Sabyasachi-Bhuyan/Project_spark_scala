import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.AmazonS3Client
import com.amazonaws.services.s3.model.AmazonS3Exception
import com.amazonaws.services.s3.model.Bucket
import com.amazonaws.auth.BasicAWSCredentials
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object SparkSql {

  def main(args: Array[String]): Unit = {

    val AWS_ACCESS_KEY="AKIARMNO5FCRKU2KYIVD"
    val AWS_SECRET_ACCESS_KEY = "nvcflJ/+MI/bh2HzmW6BG0RlXHhv83ieJXDZDWux"
    val yourAWSCredentials = new BasicAWSCredentials(AWS_ACCESS_KEY, AWS_SECRET_ACCESS_KEY)
    val amazonS3Client = new AmazonS3Client(yourAWSCredentials)

    val spark = SparkSession.builder().appName("SparkSql").master("local[*]").getOrCreate()
    spark.sparkContext.setLogLevel("ERROR")

    //val test = amazonS3Client.getObject("hadoop-spark-aws/data", "Test.csv")
    val df = spark.read.option("InferSchema", "true").option("header", "true").csv("C:\\Users\\sabya\\Desktop\\Test.csv")
    //val df = spark.read.option("InferSchema", "true").option("header", "true").csv("TEST")
    //df.show()
    //df.withColumn("abc",lit(null:String)).show()

    //df.createGlobalTempView("test_view")
    //val staticSchema=df.schema
    //print(staticSchema)
    //df.selectExpr("weight","()")

    //val df_sort = df.groupBy("weight").count.withColumnRenamed("count", "total")
      //.sort(desc("total")).limit(2)
    //df_sort.show()

    println(amazonS3Client.listBuckets())



  }
}
