package com.packt.akka

import org.scalatest.MustMatchers
import org.scalatest.{ BeforeAndAfterAll, FlatSpecLike }
import akka.remote.testkit.MultiNodeSpecCallbacks

trait BasicMultiNodeSpec extends MultiNodeSpecCallbacks
                          with FlatSpecLike
                          with MustMatchers
                          with BeforeAndAfterAll {
  override def beforeAll = multiNodeSpecBeforeAll()

  override def afterAll = multiNodeSpecAfterAll()
}