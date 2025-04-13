package _9dev.study.ranking.api.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "ksqldb")
data class KsqlDbConfig(
    val host: String,
    val port: Int,
)
