package com.unicorn.bot

import java.io.File
import java.net.URLEncoder

import info.mukel.telegram.bots.v2.methods.{SendMessage, SendPhoto}
import info.mukel.telegram.bots.v2.model.{InlineKeyboardButton, InlineKeyboardMarkup}
import info.mukel.telegram.bots.v2.model.InputFile.FromFile
import info.mukel.telegram.bots.v2.{Commands, Polling, TelegramBot}

class UnicornSampleBot(val token: String) extends TelegramBot with Polling with Commands{

  on("/hello") { implicit msg => _ =>
    reply("My token is SAFE!")
  }

  on("/pic") { implicit msg => args =>
    api.request(SendPhoto(Left(msg.chat.id), Left(FromFile(new File(this.getClass.getResource("/1.png").toURI)))))
  }

  def lmgtfyUrl(query: Seq[String]) =
    "http://lmgtfy.com/?q=" + URLEncoder.encode(query.mkString(" "), "UTF-8")

  on("/lmgtfy") { implicit message => args =>
    reply(
      lmgtfyUrl(args),
      disableWebPagePreview = Some(true)
    )
  }

  on("/lmgtfy2") { implicit message => args =>
    val markup = InlineKeyboardMarkup(Seq(Seq(
      InlineKeyboardButton("Goto Google now!", url = Option(lmgtfyUrl(args)))
    )))
    api.request(SendMessage(Left(message.sender), "Let me Google that for you!", replyMarkup = Option(markup)))
  }

}
