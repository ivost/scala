//var userDir = () => { System.getProperty("HOME") }

val localIp = java.net.InetAddress.getLocalHost.getHostAddress
println(localIp)

val hostIp = () => {
    val parts = localIp.split('.')
    if (parts.length == 4 && parts(0) == "10") {
      s"${parts(0)}.${parts(1)}.${parts(2)}.1"
    } else {
      "127.0.0.1"
    }
}
println(hostIp())


//val hostIp: (() => String) = { _ => "" }

