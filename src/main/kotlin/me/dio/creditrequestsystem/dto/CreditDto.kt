package me.dio.creditrequestsystem.dto


import jakarta.validation.constraints.Future
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotNull
import me.dio.creditrequestsystem.entity.Credit
import me.dio.creditrequestsystem.entity.Customer
import java.math.BigDecimal
import java.time.LocalDate


data class CreditDto (
    @field:NotNull(message = "Por favor, preencher o valor do crédito!") val creditValue: BigDecimal,
    @field:Future(message = "Data Inválida") val dayFirstOfInstallment: LocalDate,
    @field:Min(value = 1, message = "Valor mínimo de parcela é 1")
    @field:Max(value = 12, message = "Valor máximo de parcela é 12") val numberOfInstallments: Int,
    @field:NotNull(message = "Por favor, informar seu ID") val customerId: Long,
) {

    fun toEntity(): Credit = Credit(
        creditValue = this.creditValue,
        dayFirstInstallment = this.dayFirstOfInstallment,
        numberOfInstallments = this.numberOfInstallments,
        customer = Customer(id = this.customerId)
        )
}
