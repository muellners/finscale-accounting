package org.muellners.finscale.accounting.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.web3j.crypto.Credentials
import org.web3j.crypto.WalletUtils

@Configuration
class WalletConfiguration(
    @Value("\${wallet.password}") val walletPassword: String,
    @Value("\${wallet.path}") val walletPath: String
) {

    @Bean
    fun walletCredentials(): Credentials = WalletUtils.loadCredentials(walletPassword, walletPath)
}
