/**
  * Created by jpasseron on 16/03/2017.
  */
object HelloWorld {

  var default = "Hello, World!"
  var helloStarts = "Hello, "

  def hello() = {
    default
  }

  def hello(name:String) = {
    helloStarts + name + "!"
  }

}
