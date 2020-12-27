//Scala - Reduce, fold or scan (left/Right)
//reduceLeft, reduceRight, foldLeft, foldRight, scanLeft, scanRight

object ScalaReduceFoldScan {

  val lst = List(1,2,3,4,6,8,10,13,15)
  val lst2 = List("A","B","C")

  def main(args: Array[String]): Unit = {

    //reduceLeft
    println((lst2.reduceLeft(_+_)))
    println(lst.reduceLeft(_+_))
    println(lst.reduceLeft((x,y) => {println(x + "," + y); x+y}))

    //reduceRight
    println(lst.reduceRight((x,y) => {println(x + "," + y); x-y}))

    println(lst.foldLeft(100)(_+_))


  }

}
