package com.example.app

import com.datastax.driver.core.Cluster
import org.slf4j.LoggerFactory

/**
  * Created by stoyaiv on 11/26/16.
  */
trait CasClientInit {

  val logger = LoggerFactory.getLogger(getClass)

  def configureClient() {
    logger.info("+++ Configure client")

  }


  def closeClient() {
    logger.info("*** Closing client")

    //riakClient.shutdown()
  }



}
