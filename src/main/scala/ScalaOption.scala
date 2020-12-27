//Scala - Option (Some or None)

object ScalaOption {

  val lst = List(1,2,3)
  val map1 = Map(1 -> "Tom",2 -> "Max", 3 -> "John")
  val opt : Option[Int] = None
  val opt1 : Option[Int] = Some(66)

  def main(args: Array[String]): Unit = {

   println(lst.find(_>2).getOrElse(0))
    println(map1.get(2).getOrElse("No name found"))

    println(opt.isEmpty)
    println(opt1.isEmpty)

  }

}
