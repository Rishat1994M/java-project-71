plugins {
    application
    distribution
    id("checkstyle")
    id("java")
    id("application")
}

application { mainClass.set("hexlet.code.App") }

group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.apache.commons:commons-lang3:3.13.0")
}

tasks.test {

}