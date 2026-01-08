package com.example.loan.repository

import com.example.loan.dto.Contract
import com.example.loan.filter.ContractFilter

interface ContractRepository {
    fun createContract(contract: Contract): Contract
    fun getContracts(filter: ContractFilter): List<Contract>
}
