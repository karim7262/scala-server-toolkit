package com.avast.sst.http4s.client

import org.http4s.blaze.client.ParserMode
import org.http4s.client.defaults
import org.http4s.headers.`User-Agent`
import org.http4s.{BuildInfo, ProductComment, ProductId}

import java.util.concurrent.TimeUnit
import scala.concurrent.duration.{Duration, FiniteDuration}

final case class Http4sBlazeClientConfig(
    responseHeaderTimeout: Duration = Duration.Inf,
    idleTimeout: FiniteDuration = Duration(1, TimeUnit.MINUTES),
    requestTimeout: FiniteDuration = defaults.RequestTimeout,
    connectTimeout: FiniteDuration = defaults.ConnectTimeout,
    userAgent: `User-Agent` = `User-Agent`(ProductId("http4s-blaze-client", Some(BuildInfo.version)), List(ProductComment("Server"))),
    maxTotalConnections: Int = 10,
    maxWaitQueueLimit: Int = 256,
    maxConnectionsPerRequestkey: Int = 256,
    checkEndpointIdentification: Boolean = true,
    maxResponseLineSize: Int = 4 * 1024,
    maxHeaderLength: Int = 40 * 1024,
    maxChunkSize: Int = Int.MaxValue,
    chunkBufferMaxSize: Int = 1024 * 1024,
    parserMode: ParserMode = ParserMode.Strict,
    bufferSize: Int = 8192
)
