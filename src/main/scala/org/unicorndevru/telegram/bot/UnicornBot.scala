package org.unicorndevru.telegram.bot

import info.mukel.telegram.bots.{Commands, Polling, TelegramBot}

class UnicornBot(token: String) extends TelegramBot(token) with Polling with Commands {

  on(ConfigWrapper.hangoutsRequest) { (sender, args) =>
     replyTo(sender) { ConfigWrapper.hangoutsResponse }
  }
}

object UnicornBot {
  def apply(token: String) = new UnicornBot(token)
}
