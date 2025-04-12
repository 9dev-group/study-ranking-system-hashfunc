extra["springCloudVersion"] = "2024.0.1"

dependencyManagement {
	imports {
		mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
	}
}

dependencies {
	implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")

	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("org.springframework.cloud:spring-cloud-starter-gateway")

	implementation("net.logstash.logback:logstash-logback-encoder:8.0")
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
