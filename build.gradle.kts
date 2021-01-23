plugins {
    id("org.asciidoctor.jvm.convert") version "3.3.0"
    id("org.jetbrains.kotlin.jvm") version "1.4.10"
    id("org.jetbrains.kotlin.kapt") version "1.4.10"
    id("org.jetbrains.kotlin.plugin.allopen") version "1.4.10"
    id("com.github.johnrengelman.shadow") version "6.1.0"
    id("io.micronaut.application") version "1.3.2"
}

version = "0.1"
group = "com.feedback"

apply(from="gradle/asciidoc.gradle")
val kotlinVersion=project.properties.get("kotlinVersion")
repositories {
    mavenCentral()
    jcenter()
    maven("https://oss.jfrog.org/oss-snapshot-local")
}

micronaut {
    runtime("netty")
    testRuntime("junit5")
    processing {
        incremental(true)
        annotations("com.feedback.*")
    }
}

dependencies {
    kapt("io.micronaut.openapi:micronaut-openapi")
    kapt("io.micronaut.security:micronaut-security-annotations")
    kapt("io.dekorate:kubernetes-annotations:${dekorateVersion}")
    kapt("io.dekorate:jaeger-annotations:${dekorateVersion}")
    implementation("io.micronaut:micronaut-validation")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${kotlinVersion}")
    implementation("org.jetbrains.kotlin:kotlin-reflect:${kotlinVersion}")
    implementation("io.micronaut.kotlin:micronaut-kotlin-runtime")
    implementation("io.micronaut:micronaut-runtime")
    implementation("javax.annotation:javax.annotation-api")
    implementation("io.micronaut:micronaut-http-client")
    implementation("io.swagger.core.v3:swagger-annotations")
    implementation("io.micronaut:micronaut-management")
    implementation("io.micronaut:micronaut-multitenancy")
    implementation("io.micronaut:micronaut-discovery-client")
    implementation("io.micronaut.micrometer:micronaut-micrometer-core")
    implementation("io.micronaut.micrometer:micronaut-micrometer-registry-elastic")
    implementation("io.micronaut.netflix:micronaut-netflix-hystrix")
    implementation("io.micronaut.netflix:micronaut-netflix-ribbon")
    implementation("io.micronaut:micronaut-tracing")
    runtimeOnly("io.jaegertracing:jaeger-thrift")
    implementation("io.micronaut.liquibase:micronaut-liquibase")
    implementation("io.micronaut.sql:micronaut-jdbc-hikari")
    implementation("io.micronaut.security:micronaut-security")
    implementation("io.micronaut.elasticsearch:micronaut-elasticsearch")
    implementation("io.micronaut.graphql:micronaut-graphql")
    implementation "io.micronaut.acme:micronaut-acme"
    implementation("io.micronaut.kotlin:micronaut-kotlin-extension-functions")
    implementation("io.micronaut.cache:micronaut-cache-hazelcast")
    implementation("io.micronaut.nats:micronaut-nats")
    implementation("io.micronaut.xml:micronaut-jackson-xml")
    implementation("io.dekorate:kubernetes-annotations:${dekorateVersion}")
    implementation("io.dekorate:jaeger-annotations:${dekorateVersion}")
    implementation("org.apache.logging.log4j:log4j-core:2.12.1")
    runtimeOnly("org.apache.logging.log4j:log4j-api:2.12.1")
    runtimeOnly("org.apache.logging.log4j:log4j-slf4j-impl:2.12.1")
    runtimeOnly("com.fasterxml.jackson.module:jackson-module-kotlin")
    runtimeOnly("org.postgresql:postgresql")
    testImplementation("org.assertj:assertj-core")
    testImplementation("org.testcontainers:testcontainers")
    testImplementation("org.testcontainers:junit-jupiter")
    testImplementation("org.testcontainers:postgresql")
}


application {
    mainClass.set("com.feedback.ApplicationKt")
}

java {
    sourceCompatibility = JavaVersion.toVersion("14")
}

tasks {
    compileKotlin {
        kotlinOptions {
            jvmTarget = "14"
        }
    }
    compileTestKotlin {
        kotlinOptions {
            jvmTarget = "14"
        }
    }


}
