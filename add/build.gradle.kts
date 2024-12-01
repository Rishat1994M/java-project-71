plugins {
    application
    distribution
    //id("checkstyle")
    id("java")
    id("application")
}

application {
    mainClass.set("hexlet.code.App")
    applicationName = "app"
}
group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.apache.commons:commons-lang3:3.13.0")
    implementation("info.picocli:picocli:4.7.6")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.14.1")
}

tasks.test {
}