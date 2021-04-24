import java.util.regex.Pattern

val s = "abc"
println(s"""s is: "$s" """)

("\\bworld\\b").indexOf("Hello world")


val m = Pattern.compile(".*\\bworld\\b.*").matcher("Hello worlds")
m.matches

"(?i).*\\bjavA\\b.*".r.pattern.matcher("java").matches

"(?i).*\\bjavA\\b.*".r.pattern.matcher("java").matches
