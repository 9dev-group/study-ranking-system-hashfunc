package dev.study.ranking.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication
@ConfigurationPropertiesScan
class RankingApiApplication

fun main(args: Array<String>) {
    runApplication<RankingApiApplication>(*args)
}
