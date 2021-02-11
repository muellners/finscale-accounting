package org.muellners.finscale.accounting.service

import org.muellners.finscale.accounting.domain.enumeration.ContractType
import org.muellners.finscale.accounting.service.dto.LedgerDTO
import org.muellners.finscale.contracts.common.GanacheGasProvider
import org.muellners.finscale.contracts.generated.contracts.Ledger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.web3j.crypto.Credentials
import org.web3j.protocol.Web3j
import java.math.BigInteger
import java.util.*

/**
 * Service class for managing ledgers.
 */
@Service
class LedgerService(
    private val web3j: Web3j,
    private val credentials: Credentials,
    private val indexer: ContractDetailsIndexer
) {

    private val log = LoggerFactory.getLogger(javaClass)

    fun save(ledgerDTO: LedgerDTO): LedgerDTO {
        log.debug("Request to save Ledger : $ledgerDTO")

        ledgerDTO.id = UUID.randomUUID().toString()

        val ledgerContract = Ledger.deploy(
            web3j, credentials, GanacheGasProvider(),
            ledgerDTO.id,
            ledgerDTO.identifier,
            ledgerDTO.name,
            ledgerDTO.type.toString(),
            ledgerDTO.totalValue?.toBigIntegerExact() ?: BigInteger.ZERO,
            ledgerDTO.description ?: "",
            ledgerDTO.showAccountsInChart ?: true,
            ledgerDTO.parentLedgerId ?: ""
        ).send()

        indexer.store(ContractType.LEDGER, ledgerContract.id().send(), ledgerContract.contractAddress)

        return ledgerDTO
    }

    fun findAll(): MutableSet<LedgerDTO> {
        log.debug("Request to get all Ledgers")

        // TODO: 2/6/21 Implement getting all the addresses from indexer, retrieving details and respond )

        val ledgers = mutableSetOf<LedgerDTO>()
        val contractAddresses = indexer.retrieveAll(ContractType.LEDGER)

        for (contractAddress in contractAddresses) {
            var ledgerDTO = getLedgerDetails(contractAddress)
            ledgers.add(ledgerDTO)
        }
        return ledgers
    }

    fun findOne(id: UUID): Optional<LedgerDTO> {
        log.debug("Request to get Ledger : $id")

        val contractAddress = indexer.retrieve(ContractType.LEDGER, id.toString()) ?: return Optional.empty()
        val ledgerDTO = getLedgerDetails(contractAddress)

        return Optional.of(ledgerDTO)
    }

    fun getLedgerDetails(contractAddress: String?): LedgerDTO {
        val ledgerContract = Ledger.load(contractAddress, web3j, credentials, GanacheGasProvider())
        // TODO: 2/6/21 Possibly some kind of mapper using mapstruct
        val ledgerDTO = LedgerDTO()
        ledgerDTO.id = ledgerContract.id().send()
        ledgerDTO.identifier = ledgerContract.identifier().send()
        ledgerDTO.name = ledgerContract.name().send()
        // TODO: 2/6/21 Find some way to map between these two
//        ledgerDTO.type = ledgerContract.ledgerType().send()
        ledgerDTO.description = ledgerContract.description().send()
        ledgerDTO.totalValue = ledgerContract.totalValue().send().toBigDecimal()
        ledgerDTO.showAccountsInChart = ledgerContract.showAccountsInChart().send()
        ledgerDTO.parentLedgerId = ledgerContract.parentLedgerId().send()
        return ledgerDTO
    }
}
