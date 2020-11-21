object DiamondProblem {

  def main(args: Array[String]): Unit = {

    val k = 5
    for (i <- 1 to k ){

      for (l <- 1 to k - i  ){
        print(" ")
      }

      for (j <- 1 to i){

        print("*")
      }

     println()
    }


  }

}
