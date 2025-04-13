package _9dev.study.infrastructure.kubernetes.vector

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import org.cdk8s.Chart
import org.cdk8s.Helm

class VectorAgent(scope: software.constructs.Construct, id: String) : Chart(scope, id) {
    init {
        Helm.Builder.create(this, "vector")
            .repo("https://helm.vector.dev")
            .chart("vector")
            .version("0.41.0")
            .releaseName(id)
            .values(values)
            .build()
    }

    val values: Map<String, Any>
        get() {
            val objectMapper = ObjectMapper(YAMLFactory())
                .registerKotlinModule()
                .setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE)
            this.javaClass.classLoader.getResourceAsStream("vector/agent/values.yaml")
                .use { return objectMapper.readValue(it, Map::class.java) as Map<String, Any> }
        }
}
