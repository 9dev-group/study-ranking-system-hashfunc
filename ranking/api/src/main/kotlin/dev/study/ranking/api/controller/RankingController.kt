package dev.study.ranking.api.controller

import dev.study.ranking.api.model.RankingProduct
import dev.study.ranking.api.service.RankingService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/ranking")
class RankingController(
    private val rankingService: RankingService,
) {
    @GetMapping("/product")
    fun getProductRankings(): List<RankingProduct> {
        return rankingService.getProductRankings()
    }
}
