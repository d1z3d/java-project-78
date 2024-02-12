import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
    java
    jacoco
    id("checkstyle")
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"


repositories {
    mavenCentral()
}

val lombok_version = "1.18.30"

dependencies {
    compileOnly("org.projectlombok:lombok:" + lombok_version)
    annotationProcessor("org.projectlombok:lombok:" + lombok_version)
    testCompileOnly("org.projectlombok:lombok:" + lombok_version)
    testAnnotationProcessor("org.projectlombok:lombok:" + lombok_version)

    testImplementation(platform("org.junit:junit-bom:5.10.1"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.2")
}

tasks.compileJava {
    options.release = 20
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        exceptionFormat = TestExceptionFormat.FULL
        events = mutableSetOf(TestLogEvent.FAILED, TestLogEvent.PASSED, TestLogEvent.SKIPPED)
        showStandardStreams = true
    }
    finalizedBy(tasks.jacocoTestReport)
}

jacoco {
    toolVersion = "0.8.9"
    reportsDirectory
}

tasks.jacocoTestReport {
    reports {
        xml.required = true
    }
}