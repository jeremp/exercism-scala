/**
  * Created by jpasseron on 29/03/2017.
  */
object Hamming {
  def compute(a: String, b: String):Option[Int] = {
    if(a.length==b.length){
      Some.apply(compareDifferences(0, a.toCharArray.toList, b.toCharArray.toList))
    }else {
      None
    }
  }

  def compareDifferences(differencesCount:Int, a:List[Char], b:List[Char]):Int = {
    if(a==null || a.isEmpty){
      differencesCount
    }else{
      if(a.head==b.head){
        compareDifferences(differencesCount, a.tail, b.tail)
      }else{
        compareDifferences(differencesCount+1, a.tail, b.tail)
      }
    }
  }

}
