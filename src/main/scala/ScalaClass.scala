//Scala - class
// var - getter and setter is available
// val - getter is available
//default - No getter or setter

class User (private var Name:String, var  Age:Int){
  def printName: Unit ={
    println(Name)
  }
}
class User1 (private var Name:String, Age:Int){
  def printName: Unit ={
    println(Name)
    println(Age)
  }
}

object ScalaClass {
  def main(args: Array[String]): Unit = {

    var user = new User("Raja", 28)
    user.printName
    println(user.Age)

    var user1 = new User1("Ravi", 30)
    user1.printName

  }
}
