package com.example.app

import com.datastax.driver.core.{Cluster, Session}

import scala.concurrent.Await
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration

object MyContext {

  val port: Int = 9042
  val host: String = "127.0.0.1"

  private lazy val cluster =
    new Cluster.Builder().addContactPoints(host).withPort(port).build()

  implicit lazy val session: Session = cluster.connect()

  //val postService = new MyService(session, ExecutionContext.global)
  lazy val  myService = new MyService()

}

