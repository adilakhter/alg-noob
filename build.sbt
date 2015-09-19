import scalariform.formatter.preferences._

name := "alg-noob"

organization  := "org.xiaon"

version := "1.0"

scalaVersion := "2.11.7" 

val akkaVersion = "2.3.13"
val sprayVersion = "1.3.3"
val akkaStreamVersion="1.0"

libraryDependencies ++= Seq(
    "com.typesafe.akka"         %% "akka-actor"                     % akkaVersion,
    "com.typesafe.akka"         %% "akka-slf4j"                     % akkaVersion,
    "com.typesafe.akka"         %% "akka-persistence-experimental"  % akkaVersion,
    "com.typesafe.akka"         %% "akka-stream-experimental"       % akkaStreamVersion,
    "com.typesafe.akka"         %% "akka-http-core-experimental"    % akkaStreamVersion,
    "com.typesafe.akka"         %% "akka-http-experimental"         % akkaStreamVersion,
    "com.typesafe.akka"         %% "akka-cluster"                   % akkaVersion,
    "com.typesafe.akka"         %% "akka-contrib"                   % akkaVersion,
    "io.spray"                  %% "spray-can"                      % sprayVersion,
    "io.spray"                  %% "spray-client"                   % sprayVersion,
    "io.spray"                  %% "spray-routing"                  % sprayVersion,
    "io.spray"                  %% "spray-json"                     % "1.3.2",
    "ch.qos.logback"            %  "logback-classic"                % "1.1.3",
    "com.typesafe.akka"         %% "akka-testkit"                   % akkaVersion    % "test",
    "io.spray"                  %% "spray-testkit"                  % sprayVersion   % "test",
    "org.scalatest"             %% "scalatest"                      % "2.2.5"        % "test",
    "commons-io"                %  "commons-io"                     % "2.4"          % "test",
    "joda-time"                 %  "joda-time"                      % "2.8.2",
    "org.joda"                  %  "joda-convert"                   % "1.7",
    "com.chuusai"               %% "shapeless"                      % "2.2.5",
    "org.scalaz"                %% "scalaz-core"                    % "7.1.2"
)

scalacOptions := Seq("-encoding", "utf8",
                     "-target:jvm-1.8",
                     "-feature",
                     "-language:implicitConversions",
                     "-language:postfixOps",
                     "-unchecked",
                     "-Xfatal-warnings",
                     "-Xlint",
                     "-deprecation",
                     "-Xlog-reflective-calls",
                     "-Ywarn-unused",
                     "-Ywarn-unused-import",
                     "-Ywarn-dead-code")
scalariformSettings

ScalariformKeys.preferences := ScalariformKeys.preferences.value
  .setPreference(AlignParameters, false)
  .setPreference(AlignSingleLineCaseStatements, true)
  .setPreference(AlignSingleLineCaseStatements.MaxArrowIndent, 90)
  .setPreference(DoubleIndentClassDeclaration, true)
  .setPreference(PreserveDanglingCloseParenthesis, true)
  .setPreference(RewriteArrowSymbols, true)

scalacOptions in (Compile, console) ~= (_ filterNot (_ == "-Ywarn-unused-import"))
scalacOptions in (Test, console) := (scalacOptions in (Compile, console)).value

initialCommands in console := "import scalaz._, Scalaz._"


