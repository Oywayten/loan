package com.example.loan

import com.example.loan.dto.Contract
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.CopyOnWriteArrayList
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

class ContractController {
    private val mem = ConcurrentHashMap<String, CopyOnWriteArrayList<Contract>>()

    @OptIn(ExperimentalUuidApi::class)
    suspend fun createPersonalAgreementContract(call: RoutingCall) {

        val contract = call.receive<Contract>()

        val created = Contract(
            id = Uuid.random().toString(),
            clientId = contract.clientId
        )

        val contracts = mem.getOrPut(contract.clientId) { CopyOnWriteArrayList() }
        contracts.add(created)

        call.respond(created)
    }

    suspend fun getContracts(call: RoutingCall) {
        val clientId = call.parameters["clientId"]
        val contracts = mem[clientId].orEmpty()
        call.respond(contracts)
    }
}

