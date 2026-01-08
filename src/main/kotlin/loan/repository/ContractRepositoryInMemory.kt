package com.example.loan.repository

import com.example.loan.dto.Contract
import com.example.loan.filter.ContractFilter
import java.util.concurrent.ConcurrentHashMap
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

class ContractRepositoryInMemory : ContractRepository {
    private val mem = ConcurrentHashMap<String, Contract>()

    @OptIn(ExperimentalUuidApi::class)
    override fun createContract(contract: Contract): Contract {
        val created = contract.copy(
            id = Uuid.random().toString()
        )
        val ok = mem.putIfAbsent(created.id, created) == null
        require(ok) { "Previous value associated" }

        return created
    }

    override fun getContracts(filter: ContractFilter): List<Contract> =
        mem.values.filter { it.clientId == filter.clientId }
}
