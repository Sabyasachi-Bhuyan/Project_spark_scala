object CountString {

  def main(args: Array[String]): Unit = {

    val str = "Hello World"

    val total_length = str.length()
    val space_count = str.count(_==' ')
    val actual_char = total_length-space_count
    println("length of string : "+total_length)
    println("space count : "+space_count)
    println("Actual char count : "+actual_char)
    println(str(1)+""+str(6))
    println(str.replace('H','A'))
    println(str.replaceAll("Hello","Not"))
    println(str.toCharArray())

    //Reverse string
    println(str.reverse) //dlroW olleH

    def reverse_func(s: String): Unit ={
      for (i <- s.length - 1 to 0 by -1 )
        print(s(i))
    }
    reverse_func("chang abc")




  }

}
