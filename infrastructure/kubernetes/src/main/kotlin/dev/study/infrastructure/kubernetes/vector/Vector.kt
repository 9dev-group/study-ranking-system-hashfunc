package dev.study.infrastructure.kubernetes.vector

import org.cdk8s.Chart

class Vector(scope: software.constructs.Construct, id: String) : Chart(scope, id) {
    init {
        VectorAgent(this, "vector-agent")
    }
}
