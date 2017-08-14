name := "packt"

version := "1.0"

scalaVersion := "2.12.1"

resolvers ++= Seq(
  "snapshots" at "http://oss.sonatype.org/content/repositories/snapshots",
  "releases" at "http://oss.sonatype.org/content/repositories/releases",
  "maven central" at "https://mvnrepository.com/repos/central"
)

libraryDependencies += "com.netflix.hystrix" % "hystrix-core" % "1.5.9"