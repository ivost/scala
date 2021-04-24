package com.example.akka

import akka.actor.{Actor, ActorSystem, Props}
import com.example.akka.MusicController.{Play, Stop}
import com.example.akka.MusicPlayer.{StartMusic, StopMusic}


// Music Controller Messages
object MusicController {
  sealed trait ControllerMsg
  case object Play extends ControllerMsg
  case object Stop extends ControllerMsg

  def props = Props[MusicController]

}
// Music Controller
class MusicController extends Actor {
  def receive = {
    case Play =>
      println("Music started...")
    case Stop =>
      println("Music stopped")
  }
}

// Music Player Messages
object MusicPlayer {
  sealed trait PlayMsg
  case object StartMusic extends PlayMsg
  case object StopMusic extends PlayMsg
}
// Music Player
class MusicPlayer extends Actor {
  def receive = {
    case StartMusic =>
      println("StartMusic received...")
      // creating controller
      val ctrl = context.actorOf(MusicController.props, "controller")
      ctrl ! Play
    case StopMusic =>
      println("StopMusic received...")
    case _ =>
      println("Unknown message received")
  }
}

object Creation extends App {

  val system = ActorSystem("creation")
  val player = system.actorOf(Props[MusicPlayer], "player")

  // send start music msg to player
  player ! StartMusic
  Thread sleep 1000
  player ! StopMusic

}