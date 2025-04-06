package _9dev.study.infrastructure.kubernetes.vector

import org.cdk8s.Chart
import org.cdk8s.Helm

class VectorAgent(scope: software.constructs.Construct, id: String) : Chart(scope, id) {
    val bootstrapServers
        get() = listOf(
            "main-cluster-main-pool-0.main-cluster-kafka-brokers.default.svc.cluster.local:9092"
        ).joinToString(",")

    init {
        Helm.Builder.create(this, "vector")
            .repo("https://helm.vector.dev")
            .chart("vector")
            .version("0.41.0")
            .releaseName(id)
            .values(values)
            .build()
    }

    val values
        get() = mapOf(
            "role" to "Agent",
            "service" to service,
            "customConfig" to mapOf(
                "dataDir" to "/vector-data-dir",
                "sources" to sources,
                "sinks" to sinks,
            ),
        )

    val service
        get() = mapOf(
            "enabled" to false,
        )

    val sources
        get() = mapOf(
            "kubernetes_log_source" to mapOf(
                "type" to "kubernetes_logs",
            ),
        )

    val sinks
        get() = mapOf(
            "kubernetes_log_sink" to mapOf(
                "type" to "kafka",
                "input" to listOf(
                    "kubernetes_log_source",
                ),
                "bootstrap_servers" to bootstrapServers,
                "topic" to "infra.kubernetes.vector.logs.v1",
                "encoding" to mapOf(
                    "codec" to "json",
                ),
            ),
        )
}
