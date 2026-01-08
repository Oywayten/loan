package com.example

import com.example.loan.ContractController
import com.example.loan.repository.ContractRepositoryInMemory
import com.example.loan.service.ContractServiceImpl
import io.ktor.server.application.*

/**
 * @param args not use
 */
fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    configureRouting(
        ContractController()
    )
}
