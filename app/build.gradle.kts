plugins {
    application
    distribution
    jacoco
    checkstyle
    id("java")
    id("com.adarshr.test-logger") version "3.0.0"
    id("com.github.ben-manes.versions") version "0.39.0"

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

jacoco {
    toolVersion = "0.8.12"
    reportsDirectory = layout.buildDirectory.dir("customJacocoReportDir")
}

tasks.register<JacocoReport>("applicationCodeCoverageReport") {
    executionData(tasks.run.get())
    sourceSets(sourceSets.main.get())
}

checkstyle {
    toolVersion = "10.12.4"
}
tasks.withType<Checkstyle>().configureEach {
    reports {
        sarif.required = true
        minHeapSize = "200m"
        maxHeapSize = "1g"
    }
}

dependencies {
    implementation("org.apache.commons:commons-lang3:3.13.0")
    implementation("info.picocli:picocli:4.7.6")
    implementation("org.apache.commons:commons-collections4:4.4")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.15.0")
    testImplementation(platform("org.junit:junit-bom:5.10.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")

}

tasks.test {
    useJUnitPlatform()
    finalizedBy(tasks.jacocoTestReport)
}

tasks.jacocoTestReport {
    //reports {
       // dependsOn(tasks.test)
        reports {
            xml.required.set(true)
            //   csv.required.set(false)
            // html.required.set(true)
        //}
    }
}
