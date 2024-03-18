plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation group: 'org.junit.jupiter', name: 'junit-jupiter-api', version: '5.10.2'
    implementation group: 'org.seleniumhq.selenium', name: 'selenium-java', version: '4.18.1'
}

tasks.test {
    useJUnitPlatform()
}