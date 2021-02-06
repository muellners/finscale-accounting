package org.muellners.finscale.accounting.service

import org.muellners.finscale.accounting.domain.enumeration.ContractType

class InMemoryContractDetailsIndexer : ContractDetailsIndexer {
    private val contractTypes: HashMap<ContractType, HashMap<String, String>> = hashMapOf()

    override fun store(contractType: ContractType, id: String, address: String) {
        if (!contractTypes.containsKey(contractType)) {
            contractTypes[contractType] = hashMapOf()
        }

        contractTypes[contractType]?.set(id, address)
    }

    override fun retrieve(contractType: ContractType, id: String) = contractTypes[contractType]?.get(id)

    override fun retrieveAll(contractType: ContractType): List<String> {
        TODO("Not yet implemented")
    }
}
