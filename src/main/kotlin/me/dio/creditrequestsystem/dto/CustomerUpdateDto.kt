package me.dio.creditrequestsystem.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import me.dio.creditrequestsystem.entity.Customer
import org.hibernate.validator.constraints.br.CPF
import java.math.BigDecimal

data class CustomerUpdateDto(
    @field:NotEmpty(message = "Primeiro nome obrigatório!") val firstName: String,
    @field:NotEmpty(message = "Sobrenome obrigatório!") val lastName: String,
    @field:NotEmpty(message = "CPF obrigatório!")
    @field:CPF(message = "CPF Invalido") val email: String,
    @field:NotNull(message = "Por favor, preencher o valor da sua renda!") val income: BigDecimal,
    @field:NotEmpty(message = "CEP obrigatório!") val zipCode: String,
    @field:NotEmpty(message = "Nome da Rua obrigatório!") val street: String,
    @field:NotEmpty(message = "Nome da Cidade obrigatório!") val city: String,
    @field:NotEmpty(message = "Nome do Estado obrigatório!") val state: String,
    @field:NotEmpty(message = "Nome do País obrigatório!") val country: String,
) {
    fun toEntity(customer: Customer): Customer {
        customer.firstName = this.firstName
        customer.lastName = this.lastName
        customer.email = this.email
        customer.income = this.income
        customer.address.zipCode = this.zipCode
        customer.address.street = this.street
        customer.address.city = this.street
        customer.address.state = this.state
        customer.address.country = this.country
        return customer
    }
}
