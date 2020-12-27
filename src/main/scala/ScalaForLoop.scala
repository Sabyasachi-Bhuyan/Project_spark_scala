object ScalaForLoop {

  def main(args: Array[String]): Unit = {

    for (i <- 1 to 5){
      println("i using to " + i )
    }

    for (j <- 1.to(5)){ // to() is a function where It will take one argument
      println("j using to " + j )
    }
  }

}
