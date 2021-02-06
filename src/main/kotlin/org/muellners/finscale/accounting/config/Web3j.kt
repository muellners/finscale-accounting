package org.muellners.finscale.accounting.config

import okhttp3.OkHttpClient
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.web3j.protocol.Web3j
import org.web3j.protocol.Web3jService
import org.web3j.protocol.admin.Admin
import org.web3j.protocol.http.HttpService
import org.web3j.protocol.ipc.UnixIpcService
import org.web3j.protocol.ipc.WindowsIpcService
import java.util.concurrent.TimeUnit

@Configuration
@EnableConfigurationProperties(Web3jProperties::class)
class Web3jAutoConfiguration(
    private val properties: Web3jProperties
) {
    @Bean
    @ConditionalOnMissingBean
    fun web3j(): Web3j {
        val web3jService = buildService(properties.clientAddress)
        return Web3j.build(web3jService)
    }

    @Bean
    @ConditionalOnProperty(prefix = Web3jProperties.WEB3J_PREFIX, name = ["admin-client"], havingValue = "true")
    fun admin(): Admin {
        val web3jService = buildService(properties.clientAddress)
        return Admin.build(web3jService)
    }

    private fun buildService(clientAddress: String?): Web3jService {
        val web3jService: Web3jService
        if (clientAddress == null || clientAddress == "") {
            web3jService = HttpService(createOkHttpClient())
        } else if (clientAddress.startsWith("http")) {
            web3jService = HttpService(clientAddress, createOkHttpClient(), false)
        } else if (System.getProperty("os.name").toLowerCase().startsWith("win")) {
            web3jService = WindowsIpcService(clientAddress)
        } else {
            web3jService = UnixIpcService(clientAddress)
        }
        return web3jService
    }

    private fun createOkHttpClient(): OkHttpClient {
        val builder: OkHttpClient.Builder = OkHttpClient.Builder()
        configureTimeouts(builder)
        return builder.build()
    }

    private fun configureTimeouts(builder: OkHttpClient.Builder) {
        val tos: Long? = properties.httpTimeoutSeconds
        if (tos != null) {
            builder.connectTimeout(tos, TimeUnit.SECONDS)
            builder.readTimeout(tos, TimeUnit.SECONDS) // Sets the socket timeout too
            builder.writeTimeout(tos, TimeUnit.SECONDS)
        }
    }
}
