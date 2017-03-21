/**
  * Created by jpasseron on 20/03/2017.
  */
class Bob {

  def fine = "Fine. Be that way!"
  def sure = "Sure."
  def chillOut = "Whoa, chill out!"
  def whatever = "Whatever."

  def hey(phrase: String = "") : String = {
    if(phrase==null || phrase.trim.length() == 0){
       return fine
    }else if(phrase.toUpperCase.equals(phrase)){
      if(!noLetters(phrase) && phrase.endsWith("?")){
        return chillOut
      }else if(noLetters(phrase) && phrase.endsWith("?")){
        return sure
      }else if(!noLetters(phrase) && phrase.endsWith("!")){
        return chillOut
      }
      return whatever
    }else if(phrase.trim.endsWith("?")){
       return sure
    }
    return whatever
  }

  private def noLetters(phrase : String) : Boolean = {
    def replaced = phrase.replaceAll("[A-Za-z ]", "")
    return replaced.equals(phrase);
  }

}
