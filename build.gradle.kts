plugins {
    id("org.jetbrains.intellij.platform") version "2.2.1"
    id("org.jetbrains.kotlin.jvm") version "2.1.10"
    id("idea")
}

group = "tech.stonks"
version = "0.9.1"

repositories {
    mavenCentral()
    intellijPlatform {
        defaultRepositories()
    }
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    implementation("com.squareup.retrofit2:retrofit:2.11.0")
    implementation("com.squareup.retrofit2:adapter-rxjava3:2.11.0")
    implementation("com.squareup.retrofit2:converter-gson:2.11.0")
    implementation("com.google.code.gson:gson:2.12.1")
    implementation("io.reactivex.rxjava3:rxjava:3.1.10")
    implementation("io.reactivex.rxjava3:rxkotlin:3.0.1")
    intellijPlatform {
        intellijIdeaCommunity("2024.3.2.2")
        bundledPlugin("com.intellij.java")
        bundledPlugin("com.intellij.gradle")
        bundledPlugin("org.jetbrains.kotlin")
        pluginVerifier()
    }
}

kotlin {
    jvmToolchain(21)
}

// See https://github.com/JetBrains/gradle-intellij-plugin/
intellijPlatform {
    buildSearchableOptions = false
    pluginConfiguration {
        ideaVersion {
            sinceBuild = "243"
            untilBuild = provider { null }
        }
    }
}
