import org.unicorndevru.telegram.bot.{ConfigWrapper, UnicornBot}

object Runner extends App {
  UnicornBot(ConfigWrapper.token).run()
}
