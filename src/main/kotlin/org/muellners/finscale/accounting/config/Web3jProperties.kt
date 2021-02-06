package org.muellners.finscale.accounting.config

import org.muellners.finscale.accounting.config.Web3jProperties.Companion.WEB3J_PREFIX
import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = WEB3J_PREFIX)
class Web3jProperties {
    var clientAddress: String? = null
    var isAdminClient: Boolean? = null
    var networkId: String? = null
    var httpTimeoutSeconds: Long? = null

    companion object {
        const val WEB3J_PREFIX = "web3j"
    }
}
