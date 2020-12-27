object ScalaWhileLoop {

  def main(args: Array[String]): Unit = {

    // First will check condition then execution will happen
    var a = 0

    while (a < 10){

      println("value a :: "+a)
      a = a+1
    }

    // Atlist one execution will happen If condition is false
    var b = 10
    do{
      println("value b :: "+b)
      //b = b+1
    }while(b < 10)

  }

}
