import scala.collection.immutable.ListMap

object RunLengthEncoding {

  def encode(str: String): String = {

    if(str==null || str.trim.length<1){
      str
    }else{
      val charArray = str.toCharArray
      doEncode("", charArray.toList)
    }
  }

  def doEncode(encoded: String, reste: List[Char]): String = {
      if(reste!=null && reste.isEmpty==false){
        val extracted = extractSequence(reste)
        val toAdd = getCountString(extracted._1.size) + extracted._1.head.toString
        doEncode(encoded + toAdd, extracted._2)
      }else{
        encoded
      }
  }

  /**
    * span a list on the first Character
    * extractSequence(AABBBC) returns (AA),(BBBC)
    * @param list the list to span
    * @return
    */
  def extractSequence(list: List[Char]): (List[Char], List[Char]) = {
    val firstChar = list.head
    list.span((c) => c == firstChar)
  }

  /**
    * Properly produce count String (to print "1" as "")
    * @param count
    * @return
    */
  def getCountString(count: Integer): String ={
    if(count==1){
        ""
    }else{
      count.toString
    }
  }

  def decode(str: String): String = {
    if(str==null || str.trim.length <1){
      str
    }else{
      val charArray = str.toCharArray
      val sb = new StringBuilder
      var countString = "0"
      for(i <- 0 until charArray.length){
        val current: Char = charArray(i)
        if(current.isDigit){
          countString += current.toString
        }else{
          // write count times charToPrint into sb
          if(countString=="0"){countString="1"}
          for(y <- 0 until countString.toInt){
            sb.append(current.toString)
          }
          countString = "0"
        }
      }
      sb.toString()
    }
  }
}
