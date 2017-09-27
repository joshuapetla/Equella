lazy val BirtOsgi = config("birtosgi")
lazy val CustomCompile = config("compile") extend BirtOsgi

libraryDependencies := Seq(
  "com.github.equella.reporting" % "birt-osgi" % "3.7.2" artifacts Artifact("birt-osgi", Artifact.DefaultType, "zip"),
  "com.github.equella.reporting" % "reporting-common" % "6.5",
  "com.github.equella.reporting" % "reporting-oda" % "6.5",
  "com.github.equella.reporting" % "reporting-oda-connectors" % "6.5",
  "org.apache.commons" % "com.springsource.org.apache.commons.httpclient" % "3.1.0",
  "org.apache.commons" % "com.springsource.org.apache.commons.logging" % "1.1.1",
  "org.apache.commons" % "com.springsource.org.apache.commons.codec" % "1.6.0",
  "com.thoughtworks.xstream" %  "com.springsource.com.thoughtworks.xstream" % "1.3.1",
  "org.xmlpull" % "com.springsource.org.xmlpull" % "1.1.4.c",
  "javax.xml.stream" % "com.springsource.javax.xml.stream" % "1.0.1"
  ).map(_ % BirtOsgi)

resolvers += Resolver.url("my-test-repo", url("http://repository.springsource.com/ivy/bundles/external/"))(Patterns(false, "[organisation]/[module]/[revision]/[artifact]-[revision].[ext]"))

ivyConfigurations := overrideConfigs(BirtOsgi, CustomCompile)(ivyConfigurations.value)

jpfResourceDirs += target.value / "birt_resources"

jpfRuntime := {
  val runTime = jpfRuntime.value
  val baseDir = target.value / "birt_resources"
  IO.delete(baseDir)
  val baseBirt = baseDir / "birt"
  val outPlugins = baseBirt / "plugins"
  val ur = update.value
  val pluginJars = Classpaths.managedJars(BirtOsgi, Set("jar"), ur).files.filter(_.getName.endsWith(".jar"))
  IO.unzip(ur.select(artifact=artifactFilter(extension = "zip")).head, baseBirt)
  IO.copy(pluginJars.pair(flat(outPlugins), errorIfNone = false))
  val birtManifest = baseDirectory.value / "birt-MANIFEST.MF"
  val manifestPlugin = outPlugins / "org.eclipse.birt.api.jar"
  IO.zip(Seq(birtManifest -> "META-INF/MANIFEST.MF"), manifestPlugin)
  runTime
}
