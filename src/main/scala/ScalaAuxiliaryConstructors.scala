//Scala - Auxiliary Constructors

class User( var name:String, var Age:Int ){

 def this(){
   this("Tom",32);
 }

  def this(name: String){
    this(name,32);
  }

}

object ScalaAuxiliaryConstructors {
  def main(args: Array[String]): Unit = {
    var user1 = new User("Max",28);
    var user2 = new User();
    var user3 = new User("Hello");


  }

}
