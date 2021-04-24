package com.example.app

import org.scalatra.test.specs2._

// For more on Specs2, see http://etorreborre.github.com/specs2/guide/org.specs2.guide.QuickStart.html
class MyControllerSpec extends ScalatraSpec { def is =
  s2"""
    GET /flowers on HelloWorldServlet
        should return status 200   $getAll200
    """
  addServlet(classOf[MyController], "/flowers/*")

  def getAll200 = get("/flowers") {
    status must_== 200
  }
}
