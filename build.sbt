name := "mycf"
 
version := "1.0" 
      
lazy val `mycf` = (project in file(".")).enablePlugins(PlayJava)

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"
      
scalaVersion := "2.11.11"

libraryDependencies ++= Seq( javaJdbc , cache , javaWs ,
  "org.elasticsearch" % "elasticsearch" % "6.0.0"

)

unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )



      