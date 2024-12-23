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
    mainClass = "org.gradle.MyMain"
}
group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

jacoco {
    toolVersion = "0.8.12"
    reportsDirectory = layout.buildDirectory.dir("customJacocoReportDir")
    applyTo(tasks.run.get())
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
    finalizedBy(tasks.jacocoTestReport) // report is always generated after tests run
}
tasks.jacocoTestReport {
    reports {
        xml.required = false
        csv.required = false
        html.outputLocation = layout.buildDirectory.dir("jacocoHtml")
    }
}
tasks.jacocoTestCoverageVerification {
    violationRules {
        rule {
            limit {
                minimum = "0.5".toBigDecimal()
            }
        }

        rule {
            isEnabled = false
            element = "CLASS"
            includes = listOf("org.gradle.*")

            limit {
                counter = "LINE"
                value = "TOTALCOUNT"
                maximum = "0.3".toBigDecimal()
            }
        }
    }
}
