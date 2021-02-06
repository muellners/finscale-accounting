package org.muellners.finscale.accounting.web.rest

import io.github.jhipster.web.util.ResponseUtil
import org.muellners.finscale.accounting.service.LedgerService
import org.muellners.finscale.accounting.service.dto.LedgerDTO
import org.muellners.finscale.accounting.web.rest.errors.BadRequestAlertException
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid

private const val ENTITY_NAME = "accountingLedger"
/**
 * REST controller for managing [org.muellners.finscale.accounting.domain.Ledger].
 */
@RestController
@RequestMapping("/api")
class LedgerResource(
    private val ledgerService: LedgerService
) {

    private val log = LoggerFactory.getLogger(javaClass)

    /**
     * `POST  /ledgers` : Create a new ledger.
     *
     * @param ledgerDTO the ledgerDTO to create.
     * @return the [ResponseEntity] with status `201 (Created)` and with body the new ledgerDTO, or with status `400 (Bad Request)` if the ledgerDTO has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/ledgers")
    fun createLedger(@Valid @RequestBody ledgerDTO: LedgerDTO): LedgerDTO {
        log.debug("REST request to save Ledger : $ledgerDTO")

        if (ledgerDTO.id != null) {
            throw BadRequestAlertException(
                "A new ledger cannot already have an ID",
                ENTITY_NAME,
                "idexists"
            )
        }

        if (ledgerDTO.identifier != null) {
            // TODO: 2/4/21 Maybe implement a method in indexer and service to check this
            val identifierExists = false

            if (identifierExists) {
                throw BadRequestAlertException(
                    "A ledger with the same identifier exists",
                    ENTITY_NAME,
                    "identifierexists"
                )
            }
        }

        return ledgerService.save(ledgerDTO)
    }

    /**
     * `GET  /ledgers` : get all the ledgers.
     *
     * @return the [ResponseEntity] with status `200 (OK)` and the list of ledgers in body.
     */
    @GetMapping("/ledgers")
    fun getAllLedgers(): ResponseEntity<MutableSet<LedgerDTO>> {
        log.debug("REST request to get all Ledgers")

        return ResponseEntity.ok().body(ledgerService.findAll())
    }

    /**
     * `GET  /ledgers/:id` : get the "id" ledger.
     *
     * @param id the id of the ledgerDTO to retrieve.
     * @return the [ResponseEntity] with status `200 (OK)` and with body the ledgerDTO, or with status `404 (Not Found)`.
     */
    @GetMapping("/ledgers/{id}")
    fun getLedger(@PathVariable id: UUID): ResponseEntity<LedgerDTO> {
        log.debug("REST request to get Customer : $id")

        val ledgerDTO = ledgerService.findOne(id)
        return ResponseUtil.wrapOrNotFound(ledgerDTO)
    }
}
