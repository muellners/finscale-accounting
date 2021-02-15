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

    override fun retrieve(contractType: ContractType, id: String): String? = contractTypes[contractType]?.get(id)

    override fun retrieveAll(contractType: ContractType): List<String?> {
        // TODO 2/11/21
        val newList = arrayListOf<String>()
        contractTypes[contractType]?.forEach { (key, value) -> newList.add(value) }
        return newList
    }
}
