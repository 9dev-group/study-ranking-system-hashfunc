package dev.study.infrastructure.kubernetes

import dev.study.infrastructure.kubernetes.vector.Vector
import org.cdk8s.App
import org.cdk8s.Chart

class MainChart(scope: software.constructs.Construct, id: String) : Chart(scope, id) {
    init {
        Vector(this, "vector")
    }
}

fun main() {
    val app = App()
    MainChart(app, "main")
    app.synth()
}
