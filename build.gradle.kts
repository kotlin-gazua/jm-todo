import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  val kotlinVersion = "1.3.11"
  id("org.springframework.boot") version "2.1.1.RELEASE"
  id("org.jetbrains.kotlin.jvm") version kotlinVersion
}

version = "1.0.0-SNAPSHOT"

tasks.withType<KotlinCompile> {
  kotlinOptions {
    jvmTarget = "1.8"
    freeCompilerArgs = listOf("-Xjsr305=strict")
  }
}

val test by tasks.getting(Test::class) {
  useJUnitPlatform()
}

repositories {
  mavenCentral()
}

dependencies {
  compile("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
  compile("org.jetbrains.kotlin:kotlin-reflect")
}

