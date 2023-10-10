plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.10")
    implementation("com.google.devtools.ksp:symbol-processing-gradle-plugin:1.9.10-1.0.13")
    implementation("dev.zacsweers.moshix:dev.zacsweers.moshix.gradle.plugin:0.24.3")
}
