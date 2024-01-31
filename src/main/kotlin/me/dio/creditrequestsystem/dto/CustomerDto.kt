package me.dio.creditrequestsystem.dto

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import me.dio.creditrequestsystem.entity.Address
import me.dio.creditrequestsystem.entity.Customer
import org.hibernate.validator.constraints.br.CPF
import java.math.BigDecimal


data class CustomerDto(
    @field:NotEmpty(message = "Primeiro nome obrigatório!") val firstName: String,
    @field:NotEmpty(message = "Sobrenome obrigatório!") val lastName: String,
    @field:NotEmpty(message = "CPF obrigatório!")
    @field:CPF(message = "CPF Invalido")
    val cpf: String,
    @field:NotNull(message = "Por favor, preencher o valor da sua renda!") val income: BigDecimal,
    @field:NotEmpty(message = "Email obrigatório!")
    @field:Email(message = "Por favor, preencher o sue Email!") val email: String,
    @field:NotEmpty(message = "Senha obrigatória!") val password: String,
    @field:NotEmpty(message = "CEP obrigatório!") val zipCode: String,
    @field:NotEmpty(message = "Nome da Rua obrigatório!") val street: String,
    @field:NotEmpty(message = "Nome da Cidade obrigatório!") val city: String,
    @field:NotEmpty(message = "Nome do Estado obrigatório!") val state: String,
    @field:NotEmpty(message = "Nome do País obrigatório!") val country: String,
) {

    fun toEntity(): Customer = Customer(
        firstName = this.firstName,
        lastName = this.lastName,
        cpf = this.cpf,
        income = this.income,
        email = this.email,
        password = this.password,
        address = Address(
            zipCode = this.zipCode,
            street = this.street,
            city = this.city,
            state = this.state,
            country = this.country
        )
    )
}
