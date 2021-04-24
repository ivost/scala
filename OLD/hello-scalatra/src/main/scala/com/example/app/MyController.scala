package com.example.app

import java.util.UUID

import com.datastax.driver.core.utils.UUIDs
import org.json4s.JsonAST.{JField, JInt, JObject, JString}
import org.json4s.ext.UUIDSerializer
import org.scalatra._
import org.scalatra.swagger.{Swagger, SwaggerSupport}

import scala.concurrent.Await
import scala.concurrent.duration.Duration
import org.json4s.{CustomSerializer, DefaultFormats, Formats}
import org.scalatra.json._
//import org.json4s.jackson.JsonMethods._

// http://www.scalatra.org/2.4/guides/swagger.html

import scala.concurrent.ExecutionContext.Implicits.global

//class UUIDSerializer extends CustomSerializer[UUID](format => (
//  {
//    case JObject(JField("mostSigBits", JInt(s)) :: JField("leastSigBits", JInt(e)) :: Nil) =>
//      new UUID(s.longValue, e.longValue)
//  },
//  {
//    case x: UUID =>  JObject(JField("id", JString(x.toString)))
//  }
//))

class MyController(implicit val swagger: Swagger)
    extends ScalatraServlet
    with NativeJsonSupport
    with SwaggerSupport
    with CassSessionSupport {

  val service = MyContext.myService

  // Sets up automatic case class to JSON output serialization
  protected implicit val jsonFormats: Formats = DefaultFormats + UUIDSerializer

  //protected implicit val jsonFormats: Formats = DefaultFormats.withCompanions(classOf[UUID] ->  toString)

  // Before every action runs, set the content type to be in JSON format.
  before() {
    contentType = formats("json")
//    if (!session.contains("counter")) {
//      log.warn("NEW session")
//      session.setAttribute("counter", 0)
//    }
//    val n = 1 + session.getAttribute("counter").toString.toInt
//    session.setAttribute("counter", n)
//    log.warn("session count " + n)
    //log.warn("BEFORE " + dbSession + " " + service)
  }

  override protected val applicationName = Some("posts")
  protected val applicationDescription = "posting API. "

  val getAllPosts =
    (apiOperation[List[Post]]("getAllPosts")
      summary "Show all posts"
      notes "Shows all posts"
      parameter queryParam[Option[String]]("author").description("Authorto search for"))
 get("/", operation(getAllPosts)) {

//   val result = for {
//     posts <- service.listByAuthor("test")
//   } yield (posts)
//   val (posts) = Await.result(result, Duration(1, "second"))

   val posts = Await.result(service.listByAuthor("test"), Duration(1, "second"))

   for (post <- posts) log.warn(post.id + ", title: "+ post.title + ", author: " +  post.authorName)

   posts
//   params.get("name") match {
//      case Some(name) => FlowerData.all filter (_.name.toLowerCase contains name.toLowerCase())
//      case None => FlowerData.all
//    }
  }

  val findById =
    (apiOperation[Post]("findById")
      summary "Find by id"
      parameters (
        pathParam[String]("authorId").description("author id"),
        pathParam[String]("postId").description("post id")
      ))

//  val name:String = params.getOrElse("name", halt(400))
//  val count:Int = params.getOrElse("count", "2").toInt
//  "name: %s, count: %d\n".format(name, count)

  get("/:authorId/:postId", operation(findById)) {

    val authorId: String = params.getOrElse("authorId", halt(400))
    val postId: String = params.getOrElse("postId", halt(400))
    val id:UUID = java.util.UUID.fromString(postId)  //.replace("-", ""))
    val posts = Await.result(service.get(authorId, id), Duration(1, "second"))

    posts
  }

}
