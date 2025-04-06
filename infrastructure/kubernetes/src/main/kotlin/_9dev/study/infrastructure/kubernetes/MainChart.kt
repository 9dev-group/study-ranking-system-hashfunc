package _9dev.study.infrastructure.kubernetes

import org.cdk8s.App
import org.cdk8s.Chart


class MainChart(scope: software.constructs.Construct, id: String) : Chart(scope, id)

fun main() {
    val app = App()
    MainChart(app, "main")
    app.synth()
}
