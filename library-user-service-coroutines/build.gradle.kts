plugins {
    alias(libs.plugins.spring.dependency.management)
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.spring)
}

group = "org.jesperancinha.vtcc"
version = "0.0.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.reactor)
    implementation(libs.spring.context)
    implementation(libs.spring.web)
    implementation(libs.slf4j.api)
    implementation(libs.slf4j.simple)
    testImplementation(libs.spring.boot.starter.test)
    testImplementation(libs.kotest.assertions.core.jvm)
}

tasks.test {
    useJUnitPlatform()
    jvmArgs("--enable-preview")
}
tasks.withType<JavaCompile> {
    options.compilerArgs.add("--enable-preview")
}

kotlin {
    jvmToolchain(21)
}