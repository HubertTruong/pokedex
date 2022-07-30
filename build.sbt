ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.1.3"

lazy val root = (project in file("."))
  .settings(
    name := "pokedex",
    libraryDependencies ++= Seq(
      "com.squareup.okhttp3" % "okhttp" % "4.10.0",
    )
  )
