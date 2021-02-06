package org.muellners.finscale.accounting.service.dto

import org.muellners.finscale.accounting.domain.enumeration.LedgerType
import java.io.Serializable
import java.math.BigDecimal

/**
 * A DTO for the [org.muellners.finscale.accounting.domain.Ledger] entity.
 */
data class LedgerDTO(

    var id: String? = null,

    var identifier: String? = null,

    var name: String? = null,

    var type: LedgerType? = null,

    var description: String? = null,

    var totalValue: BigDecimal? = null,

    var showAccountsInChart: Boolean? = null,

    var parentLedgerId: String? = null

) : Serializable {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is LedgerDTO) return false
        return id != null && id == other.id
    }

    override fun hashCode() = 31
}
