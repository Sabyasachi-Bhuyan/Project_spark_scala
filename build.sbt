name := "Project_spark_scala"

version := "0.1"

scalaVersion := "2.11.12"

libraryDependencies += "com.typesafe" % "config" % "1.3.2"
libraryDependencies += "org.apache.spark" %% "spark-core" % "2.3.1"
libraryDependencies += "org.apache.spark" %% "spark-sql" % "2.3.1"
libraryDependencies += "com.amazonaws" % "aws-java-sdk" % "1.0.002"
//libraryDependencies += "com.amazonaws" % "aws-java-sdk" % "1.11.46"
libraryDependencies += "mysql" % "mysql-connector-java" % "8.0.15"