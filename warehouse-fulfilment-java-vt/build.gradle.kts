plugins {
    id("java")
    alias(libs.plugins.spring.boot)
    alias(libs.plugins.spring.dependency.management)
}

group = "org.jesperancinha.vtcc"
version = "0.0.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation(libs.postgresql)
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation(platform("org.junit:junit-bom:5.12.2"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.junit.platform:junit-platform-engine")
}

tasks.test {
    useJUnitPlatform()
}
tasks.bootJar {
    archiveFileName.set("warehouse-fulfilment.jar")
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(24)
    }
}
