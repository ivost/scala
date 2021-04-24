package course1.section1.video_1_9

import java.util.concurrent.{ExecutorService, Executors}


object ThreadPerRequestExample {
  val poolSize = 16
  val pool: ExecutorService = Executors.newFixedThreadPool(poolSize)

  //process the Request in a thread per request fashion
  def processRequest(httpRequest: HttpRequest): Unit = {
    pool.execute(new Runnable {
      override def run(): Unit = computation(httpRequest)
    })
  }

  def computation(httpRequest: HttpRequest): Unit = {
    //long running action when thread is blocked waiting for some resource
    println(s"handling request: ${httpRequest.id}")
  }

  def main(args: Array[String]): Unit = {
    processRequest(new HttpRequest("123"))
    processRequest(new HttpRequest("123"))
  }
}


