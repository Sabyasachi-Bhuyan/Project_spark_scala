import java.io.File

import scala.io.Source
import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.AmazonS3Client
import com.amazonaws.services.s3.model.AmazonS3Exception
import com.amazonaws.services.s3.model.Bucket
import com.amazonaws.auth.BasicAWSCredentials
import org.apache.spark.sql.SparkSession


object PropertiesRead {

  def main(args: Array[String]): Unit = {

    var configMap = Source.fromFile("C:\\Users\\sabya\\IdeaProjects\\Project_spark_scala\\src\\main\\resources\\application.properties")
      //.getLines().filter(l => l.contains("="))
      //.map{l => val tk = l.split("=");if (tk.size==1){ (tk(0) -> "" )}else{(tk(0) -> tk(1))}}.toMap
      .getLines().map{l => val tk = l.split("="); (tk(0) -> tk(1))}.toMap


    val AWS_ACCESS_KEY= configMap("AWS_ACCESS_KEY")
    val AWS_SECRET_ACCESS_KEY = configMap("AWS_SECRET_ACCESS_KEY")
    val yourAWSCredentials = new BasicAWSCredentials(AWS_ACCESS_KEY, AWS_SECRET_ACCESS_KEY)
    val amazonS3Client = new AmazonS3Client(yourAWSCredentials)


    //BucketName
    val bucket_name = "destination-12345"

    //val spark = SparkSession.builder().appName("PropertiesRead").master("local[*]").getOrCreate()
    //val df = spark.read.csv("C:\\Users\\sabya\\Desktop\\Data Sets\\Test2.csv")
    val file_name = "C:\\Users\\sabya\\Desktop\\Data Sets\\Test2.csv"
    val abc = amazonS3Client.listBuckets()
    println(abc)

    //amazonS3Client.putObject(bucket_name,AWS_SECRET_ACCESS_KEY,new File(file_name))

  }

}
