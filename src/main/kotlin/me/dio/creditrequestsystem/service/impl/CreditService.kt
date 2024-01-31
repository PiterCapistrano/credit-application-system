package me.dio.creditrequestsystem.service.impl

import me.dio.creditrequestsystem.entity.Credit
import me.dio.creditrequestsystem.exception.BusinessException
import me.dio.creditrequestsystem.repository.CreditRepository
import me.dio.creditrequestsystem.service.ICreditService
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class CreditService (
    private val creditRepository: CreditRepository,
    private val customerService: CustomerService
) : ICreditService {
    override fun save(credit: Credit): Credit {
        credit.apply {
            customer = customerService.findById(credit.customer?.id!!)
        }
        return this.creditRepository.save(credit)
    }
    override fun findAllByCustomer(customerId: Long): List<Credit> =
        this.creditRepository.findAllByCustomerId(customerId)

    override fun findByCreditCode(customerId: Long, creditCode: UUID): Credit {
        val credit: Credit = (this.creditRepository.findByCreditCode(creditCode)
            ?: throw BusinessException("Creditcode $creditCode not found"))
        return if (credit.customer?.id == customerId) credit else throw IllegalArgumentException("Contact admin")
        /*if (credit.customer?.id == customerId) {
        return credit
        } else {
        throw RunTimeException("Contact admin")
         }*/
    }
}