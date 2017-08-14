package com.example.app

import com.datastax.driver.core.{Cluster, Session}
import org.scalatra.ScalatraBase
import org.slf4j.LoggerFactory
import scala.concurrent.ExecutionContext.Implicits.global


/**
  * Created by stoyaiv on 11/26/16.
  */
object CasSessionSupport {

  val key = {
    val n = getClass.getName
    if (n.endsWith("$")) n.dropRight(1) else n
  }

  val port: Int = 9042
  val host: String = "127.0.0.1"

  lazy val cluster =
    new Cluster.Builder()
      .addContactPoints(host)
      .withPort(port)
      .build()

//  val service: getMyService(): MyService = {
//
//  }

}

trait CassSessionSupport { this: ScalatraBase =>
  import CasSessionSupport._

  val log = LoggerFactory.getLogger(getClass)

//  val port: Int = 9042
//  val host: String = "127.0.0.1"
//
//  lazy val cluster =
//    new Cluster.Builder()
//      .addContactPoints(host)
//      .withPort(port)
//      .build()

  //def dbSession = request.get(key).orNull.asInstanceOf[Session]
  //def service = request.get(key).orNull.asInstanceOf[MyService]

  //protected var service: MyService

  before() {
//    log.warn("before, key " + key + " " + request.get(key))
//    if (request.get(key).isEmpty) {
//      log.warn("*** NEW SESSION")
//      implicit val ses: Session = cluster.connect()
//      val service = new MyService()
//      request(key) = service
//    }

//    if (service == null) {
//      log.warn("*** NEW SESSION")
//      implicit val ses: Session = cluster.connect()
//      service = new MyService()
//    }

  }

  after() {
    //log.warn("after, key " + key)
    //dbSession.close
  }

}
