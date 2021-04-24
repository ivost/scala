package com.example.app
import org.scalatra.swagger.{ApiInfo, NativeSwaggerBase, Swagger}
import org.scalatra.ScalatraServlet

class ResourcesApp(implicit val swagger: Swagger)
  extends ScalatraServlet with NativeSwaggerBase

/*
  swagger
  http://localhost:8080/api-docs/flowers

  to browse the api
  http://petstore.swagger.io/
  then paste in the box
  http://localhost:8080/api-docs
  click explore


  https://github.com/scalatra/scalatra-website-examples/tree/master/2.4/swagger-example
 */

object MyApiInfo extends ApiInfo(
  "The Flowershop API",
  "Docs for the Flowers API",
  "http://scalatra.org",
  "apiteam@scalatra.org",
  "MIT",
  "http://opensource.org/licenses/MIT")

class MySwagger extends Swagger(Swagger.SpecVersion, "1.0.0", MyApiInfo)
