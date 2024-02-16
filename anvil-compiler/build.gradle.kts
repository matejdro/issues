plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
    id("kotlin-kapt")
}

dependencies {
    api("com.squareup.anvil:gradle-plugin:2.5.0-beta01")
    implementation("com.squareup.anvil:compiler-api:2.5.0-beta01")
    implementation("com.squareup.anvil:compiler-utils:2.5.0-beta01")
    implementation("com.google.dagger:dagger:2.50")
    compileOnly("com.google.auto.service:auto-service-annotations:1.0")
    kapt("com.google.auto.service:auto-service:1.0")
}

kotlin {
    jvmToolchain(17)
}
