import scala.collection.immutable.ListMap

object RunLengthEncoding {

  def encode(str: String): String = {

    if(str==null || str.trim.length<1){
      str
    }else{
      var result = ""

      var charArray = str.toCharArray
      var count = 1

      for(i <- 0 until charArray.length-1){

        val current: Char = charArray(i)
        val next: Char = charArray(i + 1)

        if(i < charArray.length-2){
          if(current!=next){
            result += getCountString(count) + current.toString
            count = 1
          }
          else{
            count += 1
          }
        }else{
          if(current!=next){
            result += getCountString(count) + current.toString + next.toString
            count = 1
          }else{
            result += getCountString(count+1) + current.toString
          }
        }
      }
      result
    }
  }

  def getCountString(count: Integer): String ={
    if(count==1){
        ""
    }else{
      count.toString
    }
  }

  def decode(str: String): String = {
    str
  }
}
