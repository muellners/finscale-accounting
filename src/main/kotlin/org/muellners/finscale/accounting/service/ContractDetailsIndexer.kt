package org.muellners.finscale.accounting.service

import org.muellners.finscale.accounting.domain.enumeration.ContractType

interface ContractDetailsIndexer {

    fun store(contractType: ContractType, id: String, address: String)
    fun retrieve(contractType: ContractType, id: String): String?
    fun retrieveAll(contractType: ContractType): List<String?>
}
