package course1.section1.video_1_10

import java.util.UUID

import com.netflix.hystrix.{HystrixCommand, HystrixCommandGroupKey}

class CircuitBreakerExample(dbQuery: String, dbService: DbService)
  extends HystrixCommand[String](HystrixCommandGroupKey.Factory.asKey("databaseRequest")) {


  override def run(): String = {
    dbService.queryForId(dbQuery)
  }

  override def getFallback: String = {
    //return some default value
    "not-found"
  }
}


class DbService {
  def queryForId(dbQuery: String): String = {
    //expensive query to db
    UUID.randomUUID().toString
  }
}