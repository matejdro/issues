plugins {
   `kotlin-dsl`
}

repositories {
   mavenCentral()
   gradlePluginPortal()
}

dependencies {
   // Workaround to have libs accessible (from https://github.com/gradle/gradle/issues/15383)
   // compileOnly(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
}
