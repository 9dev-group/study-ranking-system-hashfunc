package _9dev.study.ranking.api.service

import _9dev.study.ranking.api.config.KsqlDbConfig
import _9dev.study.ranking.api.model.RankingProduct
import io.confluent.ksql.api.client.Client
import io.confluent.ksql.api.client.ClientOptions
import org.springframework.stereotype.Service

@Service
class RankingService(
    ksqlDbConfig: KsqlDbConfig
) {
    private val client: Client = Client.create(
        ClientOptions.create()
            .setHost(ksqlDbConfig.host)
            .setPort(ksqlDbConfig.port)
    )

    fun getProductRankings(): List<RankingProduct> {
        return client.executeQuery("SELECT * FROM ranking_product_access WHERE WINDOWEND < UNIX_TIMESTAMP();")
            .get()
            .map { row ->
                RankingProduct(
                    path = row.getString("PATH"),
                    count = row.getLong("COUNT"),
                )
            }
            .sortedBy { -it.count }
    }
}
