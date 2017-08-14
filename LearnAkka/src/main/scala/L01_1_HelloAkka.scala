import akka.actor.{Actor, ActorSystem, Props}

/**
  * Created by stoyaiv on 11/27/16.
  */

// define Actor Messages
case class WhoToGreet(who: String)

// greeter actor
class Greeter extends Actor {
  def receive = {
    case WhoToGreet(who) => println(s"Hello $who")
  }
}

object HelloAka extends App {
    val system = ActorSystem("Hello-Akka")
    val greeter = system.actorOf(Props[Greeter], "greeter")
    // send message
    greeter ! WhoToGreet("Ivo")
}
