package com.example.loan.service

import com.example.loan.dto.Contract
import com.example.loan.filter.ContractFilter
import com.example.loan.repository.ContractRepository

class ContractServiceImpl(
    private val contractRepository: ContractRepository
) : ContractService {

    override fun createPersonalAgreementContract(req: Contract): Contract {
        return contractRepository.createContract(req)
    }

    override fun getContracts(filter: ContractFilter): List<Contract> {
        return contractRepository.getContracts(filter)
    }
}

