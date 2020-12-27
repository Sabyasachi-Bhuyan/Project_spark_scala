object ScalaDiamondProgramming {

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

    for (i <- 1 to num  ){


      for (k <- 1 to i -1 ){
        print(" ")
      }
      for (j <- 1 to num  - i ){

        print(" *")
      }

      println()

    }


  }

}
