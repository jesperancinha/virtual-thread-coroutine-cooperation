plugins {
    alias(libs.plugins.kotlin.jvm)
}

group = "org.jesperancinha.vtcc"
version = "0.0.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(24)
}
tasks.withType<JavaCompile>().configureEach {
    sourceCompatibility = "23"
    targetCompatibility = "23"
}
tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    compilerOptions {
        jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_23)
    }
}

tasks.register("prepareKotlinBuildScriptModel"){}
