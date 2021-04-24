package com.packt.akka

import akka.actor.{ActorRef, ActorSystem, Props, Actor, Terminated}

// ares is parent of athena
class Ares(athena: ActorRef) extends Actor {

  override def preStart() = {
    println("Ares preStart - will monitor Athena...")
    // use watch to monitor child
    context.watch(athena)
    /////////////////////
  }

  override def postStop() = {
    println("Ares postStop: child path: " + athena.path)
  }

  def receive = {
    case Terminated =>
      println("Ares terminates")
      context.stop(self)
  }
}

class Athena extends Actor {

  def receive = {
    case msg =>
      println(s"Athena received ${msg} - will stop now")
      context.stop(self)
  }

}

object Monitoring extends App {

  // Create the 'monitoring' actor system
  val system = ActorSystem("monitoring")

  // create child
  val athena = system.actorOf(Props[Athena], "athena")

  // create parent
  // pass child reference to athena
  val ares = system.actorOf(Props(classOf[Ares], athena), "ares")

  athena ! "Hi"

  //Thread.sleep(200)

  system.terminate()
}