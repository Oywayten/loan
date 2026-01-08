package com.example

import com.example.loan.ContractController
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting(
    contractController: ContractController
) {
    install(ContentNegotiation) {
        json()
    }
    routing {
        post("/contract/") {
            contractController.createPersonalAgreementContract(call)
        }
        get("/contract/{clientId}") {
            contractController.getContracts(call)
        }
    }
}
