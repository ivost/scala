package com.example.app

import com.datastax.driver.core.{Cluster, Session}

import scala.concurrent.{Await, ExecutionContext}
import scala.concurrent.duration.Duration
import scala.concurrent.ExecutionContext.Implicits.global

object Main extends App {
  val port: Int = 9042
  val host: String = "127.0.0.1"

  private val cluster =
    new Cluster.Builder().addContactPoints(host).withPort(port).build()

  implicit val session: Session = cluster.connect()

  val postService = new MyService()

  val result = for {
    _ <- postService.create("test", "title")
    posts <- postService.listByAuthor("test")
    postId = posts.head.id
    _ <- postService.update("test", postId, "new title")
    updatedPost <- postService.get("test", postId)
    _ <- postService.delete("test", postId)
    deletedPosts <- postService.listByAuthor("test")
  } yield (posts, updatedPost, deletedPosts)

  val (posts, updatedPost, deletedPosts) = Await.result(result, Duration(1, "second"))

  println(posts)
  println(updatedPost)
  println(deletedPosts)

  session.close()
  cluster.close()
}
