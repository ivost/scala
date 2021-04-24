package foo

import utest.{TestSuite, Tests, assert, test}

object ExampleTests extends TestSuite {
  def tests = Tests {
    test("hello") {
      val result = Example.hello()
      assert(result == "Hello World")
      result
    }
  }
}
