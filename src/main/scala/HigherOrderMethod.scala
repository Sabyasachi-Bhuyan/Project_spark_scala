//Scala - map and filter

object HigherOrderMethod {

  val lst = List(1,2,3,4,6,7,9,10,13)
  val mymap = Map(1->"Tom", 2 -> "Max", 3 -> "John")

  def main(args: Array[String]): Unit = {

    println(lst.map(x => x * 2))
    println(lst.map(x => "hi" * x ))
    println(mymap.mapValues(x => "hi" + x ))
    println("hello".map(x => x.toUpper))
    println(List(List(1,2,3),List(4,5,6)).flatten)

    println(lst.flatMap(x => List(x+1)))
    println(lst.map(x => List(x+1)))
    println(lst.map(x => List(x+1)).flatten)

    println(lst.filter(x => x%2 == 0)) //even value


  }

}

