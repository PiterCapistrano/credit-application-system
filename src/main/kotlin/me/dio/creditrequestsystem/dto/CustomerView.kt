package me.dio.creditrequestsystem.dto

import me.dio.creditrequestsystem.entity.Customer
import java.math.BigDecimal

data class CustomerView (
    val firstName: String,
    val lastName: String,
    val cpf: String,
    val income: BigDecimal,
    val email: String,
    val password: String,
    val zipCode: String,
    val street: String,
    val city: String,
    val state: String,
    val country: String,
) {
    constructor(customer: Customer): this (
        firstName = customer.firstName,
        lastName = customer.lastName,
        cpf = customer.cpf,
        income = customer.income,
        email = customer.email,
        password = customer.password,
        zipCode = customer.address.zipCode,
        street = customer.address.street,
        city = customer.address.city,
        state = customer.address.state,
        country = customer.address.country
    )

}
