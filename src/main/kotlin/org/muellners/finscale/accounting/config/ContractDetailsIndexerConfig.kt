package org.muellners.finscale.accounting.config

import org.muellners.finscale.accounting.service.InMemoryContractDetailsIndexer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile

@Configuration
class ContractDetailsIndexerConfig {

    @Bean
    @Profile("dev")
    fun inMemoryContractDetailsIndexer() = InMemoryContractDetailsIndexer()
}
