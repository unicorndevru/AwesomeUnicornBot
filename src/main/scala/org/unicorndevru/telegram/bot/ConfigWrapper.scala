package org.unicorndevru.telegram.bot
import net.ceedubs.ficus.Ficus._

import com.typesafe.config.ConfigFactory

object ConfigWrapper {
  val config = ConfigFactory.load
  val token = config.as[Option[String]]("token").getOrElse("none")

  lazy val hangoutsDefaultRequest = "пыщ-пыщ"

  lazy val hangoutsDefaultResponse = "https://plus.google.com/hangouts/_/g6cd6sotlrwqjq3adowodrac34a"
  lazy val hangoutsRequest = config.as[Option[String]]("hangouts.request").getOrElse(hangoutsDefaultRequest)

  lazy val hangoutsResponse = config.as[Option[String]]("hangouts.response").getOrElse(hangoutsDefaultResponse)
}
