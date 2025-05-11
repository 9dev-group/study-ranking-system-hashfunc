package dev.study.gateway.configuration

import org.springframework.boot.web.embedded.netty.NettyReactiveWebServerFactory
import org.springframework.boot.web.embedded.netty.NettyServerCustomizer
import org.springframework.boot.web.server.WebServerFactoryCustomizer
import org.springframework.context.annotation.Configuration
import reactor.netty.http.server.logging.AccessLog
import java.net.InetSocketAddress

@Configuration
class AccessLogCustomizer : WebServerFactoryCustomizer<NettyReactiveWebServerFactory> {
    override fun customize(factory: NettyReactiveWebServerFactory) {
        factory.addServerCustomizers(
            NettyServerCustomizer { server ->
                server.accessLog(true) { args ->
                    AccessLog.create(
                        "{} - {} [{}] \"{} {} {}\" {} {}",
                        (args.connectionInformation()?.remoteAddress() as InetSocketAddress).hostString,
                        args.user(),
                        args.accessDateTime()?.withFixedOffsetZone(),
                        args.method(),
                        args.uri(),
                        args.protocol(),
                        args.status(),
                        if (args.contentLength() > -1L) args.contentLength() else "-",
                    )
                }
            },
        )
    }
}
