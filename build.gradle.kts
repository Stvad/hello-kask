import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.stvad.kask.gradle.Kask

plugins {
    java
    kotlin("jvm") version "1.3.21"
    id("org.stvad.kask") version "0.1.5"
    id("org.gretty") version "2.2.0"

    war
}

group = "org.stvad"
version = "0.1.0"

repositories {
    mavenCentral()
    maven(url = "https://jitpack.io")
    jcenter()
}

dependencies {
    compile(kotlin("stdlib-jdk8"))
    compile("javax.servlet", "javax.servlet-api", "3.0.1") // Required only by "Servlet" version of the skill
    implementation("org.apache.logging.log4j:log4j-api:2.9.0") { isForce = true }
    implementation("org.apache.logging.log4j:log4j-slf4j-impl:2.9.0") { isForce = true }
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}
tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

tasks.withType<Kask> {
    packageName = "org.stvad.kask.example.model"
    modelPath.set(layout.projectDirectory.dir("models").file("en-US.json"))
}

val buildLambdaArchive by tasks.creating(Zip::class) {
    val compileKotlin: KotlinCompile by tasks
    from(compileKotlin)

    val compileJava: JavaCompile by tasks
    from(compileJava)

    val processResources: ProcessResources by tasks
    from(processResources)

    into("lib") {
        from(configurations.runtimeClasspath)
    }
}

gretty {
    // Setting this argument is useful for testing purposes with e.g. bespoken cli: https://read.bespoken.io/cli/commands/
//     jvmArgs = listOf("-Dcom.amazon.ask.servlet.disableRequestSignatureCheck=true")
}
