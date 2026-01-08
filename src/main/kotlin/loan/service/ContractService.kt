package com.example.loan.service

import com.example.loan.dto.Contract
import com.example.loan.filter.ContractFilter

interface ContractService {
    fun createPersonalAgreementContract(req: Contract): Contract
    fun getContracts(filter: ContractFilter): List<Contract>
}
