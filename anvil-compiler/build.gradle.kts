plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
    id("kotlin-kapt")
}

dependencies {
    api("com.squareup.anvil:gradle-plugin:2.4.5")
    implementation("com.squareup.anvil:compiler-api:2.4.5")
    implementation("com.squareup.anvil:compiler-utils:2.4.5")
    implementation("com.google.dagger:dagger:2.45")
    compileOnly("com.google.auto.service:auto-service-annotations:1.0")
    kapt("com.google.auto.service:auto-service:1.0")
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}
