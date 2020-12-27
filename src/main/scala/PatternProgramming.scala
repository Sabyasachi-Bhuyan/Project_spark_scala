object PatternProgramming {

  def main(args: Array[String]): Unit = {

    val num = 5

    for (i <- 1 to num  ){

      for (j <- 1 to num -i ){

        print(" ")
      }
      for (k <- 1 to i  ){
        print("* ")
      }

      println()

    }

  }

}
