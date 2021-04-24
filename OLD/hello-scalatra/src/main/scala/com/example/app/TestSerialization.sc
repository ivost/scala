import java.util.Date
import org.json4s._
import org.json4s.native.Serialization
import org.json4s.native.Serialization.{ read, write, writePretty }


case class Player(name: String, dob: Date, value: Int)

implicit val formats = Serialization.formats(NoTypeHints)

val p = new Player("Ivo", new Date(), 10)

val json = write(p)

println(json)

val decoded = read[Player](json)

println(decoded)
