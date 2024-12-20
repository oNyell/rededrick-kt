import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
plugins {
    kotlin("jvm") version "2.0.21"
    kotlin("plugin.lombok") version "2.0.21"
    id("io.freefair.lombok") version "8.10"
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

group = "com.rededrick.commons"
version = "1.0"

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/") {
        name = "papermc-repo"
    }
    maven("https://oss.sonatype.org/content/groups/public/") {
        name = "sonatype"
    }
}

dependencies {
    implementation("com.velocitypowered:velocity-api:3.4.0-SNAPSHOT")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.reflections:reflections:0.9.11")
    testImplementation("junit:junit:4.13.2")
}

val targetJavaVersion = 17
kotlin {
    jvmToolchain(targetJavaVersion)
}

val templateSource = file("src/main/templates")
val templateDest = layout.buildDirectory.dir("generated/sources/templates")
val generateTemplates = tasks.register<Copy>("generateTemplates") {
    val props = mapOf("version" to project.version)
    inputs.properties(props)

    from(templateSource)
    into(templateDest)
    expand(props)
}


tasks.named<ShadowJar>("shadowJar") {
    relocate("kotlin", "com.rededrick.commons.kotlin")
    archiveBaseName.set("commons")
}

val copyJar = tasks.register<Copy>("copyJar") {
    from("$buildDir/libs")
    into("C:/Users/euope/Documents/GitHub/servidores/velocity/plugins")
    include("**/*.jar")
}
tasks.named("shadowJar") {
    finalizedBy(copyJar)
}

sourceSets.main.configure { java.srcDir(generateTemplates.map { it.outputs }) }

