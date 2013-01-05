import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

    val appName         = "fourcrawl"
    val appVersion      = "1.0-SNAPSHOT"

    val appDependencies = Seq(
      "fi.foyt" % "foursquare-api" % "1.0.2"
    )

    val main = PlayProject(appName, appVersion, appDependencies, mainLang = JAVA).settings(
      
      resolvers += "Foursquare API" at "http://foursquare-api-java.googlecode.com/svn/repository"
      
    )

}
