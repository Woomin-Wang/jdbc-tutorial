plugins {
    application
    id("java")
    id("com.github.johnrengelman.shadow") version "8.1.1"
    id("org.springframework.boot") version "3.4.2"
    id("io.spring.dependency-management") version "1.1.7"

}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.postgresql:postgresql:42.7.5")
    implementation("org.mybatis:mybatis:3.5.19")

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    implementation("org.springframework.boot:spring-boot-starter-web:3.4.2")
}

tasks.getByName("run", JavaExec::class)
{
    standardInput = System.`in`
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<Jar> {
    manifest {
        attributes["Main-Class"] = "wisoft.AppInit4"
    }
}

tasks.shadowJar {
    archiveClassifier.set("all")
    mergeServiceFiles()
}

application {
    mainClass = "wisoft.AppInit4"
}