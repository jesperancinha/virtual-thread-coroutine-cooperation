plugins {
    kotlin("jvm") version "2.0.21"
}

group = "org.jesperancinha.vtcc"
version = "0.0.0"

repositories {
    mavenCentral()
}

dependencies {
    api(libs.kotlinx.coroutines.core)
    testImplementation("org.jetbrains.kotlin:kotlin-test")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}

tasks.register("prepareKotlinBuildScriptModel"){}
