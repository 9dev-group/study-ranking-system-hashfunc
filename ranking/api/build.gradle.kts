repositories {
    maven {
        url = uri("https://packages.confluent.io/maven/")
    }
    maven {
        url = uri("https://confluent-snapshots.public.confluent.io/")
    }
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-web") {
        exclude("org.springframework.boot", "spring-boot-starter-tomcat")
    }
    implementation("org.springframework.boot:spring-boot-starter-undertow")

    implementation("io.confluent.ksql:ksqldb-api-client:7.9.0") {
        exclude("org.slf4j", "slf4j-reload4j")
    }

    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

jib {
    from {
        image = "gcr.io/distroless/java21-debian12"
    }
    to {
        image = project.name
        tags = setOf(project.version.toString())
    }
}
