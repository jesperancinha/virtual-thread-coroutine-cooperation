plugins {
    alias(libs.plugins.spring.boot)
    alias(libs.plugins.spring.dependency.management)
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.spring)
}

group = "org.jesperancinha"
version = "1.0-SNAPSHOT"

tasks.bootJar {
    archiveFileName.set("warehouse-fulfilment.jar")
}

repositories {
    mavenCentral()
}

dependencies {
    // Core dependencies
    implementation("org.springframework.boot:spring-boot-starter")

    // Reactive programming support
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation(libs.kotlinx.coroutines.core)

    // Testing dependencies
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}

tasks.register("prepareKotlinBuildScriptModel") {}
