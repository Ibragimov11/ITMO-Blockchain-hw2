plugins {
    application
    kotlin("jvm") version "1.7.20"
    id("org.web3j") version "4.9.4"
}

group = "io.github.rorione"
version = "0.0.1"
application {
    mainClass.set("Main.kt")
}

repositories {
    mavenCentral()
    maven {
        url = uri("https://hyperledger.jfrog.io/hyperledger/besu-maven")
        content { includeGroupByRegex("org\\.hyperledger\\..*") }
    }
    maven {
        url = uri("https://artifacts.consensys.net/public/maven/maven/")
        content { includeGroupByRegex("tech\\.pegasys\\..*") }
    }
    maven {
        url = uri("https://dl.cloudsmith.io/public/consensys/quorum-mainnet-launcher/maven/")
        content { includeGroupByRegex("net\\.consensys\\..*") }
    }
    maven {
        url = uri("https://splunk.jfrog.io/splunk/ext-releases-local")
        content { includeGroupByRegex("com\\.splunk\\..*") }
    }
    @Suppress("DEPRECATION")
    jcenter()
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
}

dependencies {
    // Web3j
    implementation("org.web3j:core:4.9.4")

    // Tests
    testImplementation("io.kotest:kotest-runner-junit5:5.5.2")
    testImplementation("org.web3j:web3j-unit:4.9.4")
}
