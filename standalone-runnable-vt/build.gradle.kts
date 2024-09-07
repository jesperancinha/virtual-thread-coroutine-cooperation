plugins {
    alias(libs.plugins.spring.boot)
    alias(libs.plugins.spring.dependency.management)
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.spring)
}

group = "org.jesperancinha.vtcc"
version = "0.0.0"

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

    // Testing dependencies
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.test {
    useJUnitPlatform()
}