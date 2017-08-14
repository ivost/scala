package course1.section1.video_1_9

import java.util.UUID

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Success}


object AsyncRequestProcessingExample {

  def processRequest(request: HttpRequest): Unit = {
    val futureResult = Future {
      computation(request)
    }

    futureResult.onComplete {
      case Success(result) => println(s"processing finished with result: $result")
      case Failure(t) => println("error while completing async operation")
    }
  }

  def computation(httpRequest: HttpRequest): String = {
    //long running action when if thread needs to wait for external resource, thread will pick up another request handling
    //from the event queue
    println(s"handling request: ${httpRequest.id}")
    UUID.randomUUID().toString
  }

  def main(args: Array[String]): Unit = {
    processRequest(new HttpRequest("123"))
    processRequest(new HttpRequest("456"))

    Thread.sleep(10000)
  }
}
