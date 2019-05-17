name := "ONLINE_LESSONS"
 
version := "1.0" 
      
lazy val `online_lessons` = (project in file(".")).enablePlugins(PlayScala)

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"
      
resolvers += "Akka Snapshot Repository" at "http://repo.akka.io/snapshots/"
      
scalaVersion := "2.12.2"

libraryDependencies ++= Seq( jdbc , ehcache , ws , specs2 % Test , guice )

// https://mvnrepository.com/artifact/org.reactivemongo/play2-reactivemongo
libraryDependencies += "org.reactivemongo" %% "play2-reactivemongo" % "0.16.6-play27"





unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )  

      