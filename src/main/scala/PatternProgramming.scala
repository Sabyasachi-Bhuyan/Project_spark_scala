object PatternProgramming {

  def main(args: Array[String]): Unit = {

    val num = 4

    for (i <- 0 to num){

      for (j <- 0 to num - i - 1 ){

        print(" ")
      }
      for (k <- 0 to i + 1){
        print("*"+" ")
      }
      println()

    }

  }

}
