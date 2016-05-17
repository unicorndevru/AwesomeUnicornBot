import com.unicorn.bot.UnicornSampleBot

object Runner extends App {

  val token = sys.env.getOrElse("TTOKEN","EMPTY")

  val bot = new UnicornSampleBot(token)

  bot.run()


}
