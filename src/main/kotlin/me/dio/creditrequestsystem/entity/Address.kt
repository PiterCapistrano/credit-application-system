package me.dio.creditrequestsystem.entity

import jakarta.persistence.Column
import jakarta.persistence.Embeddable

@Embeddable
data class Address(
        @Column(nullable = false) var zipCode: String = "",
        @Column(nullable = false) var street: String = "",
        @Column(nullable = false) var city: String = "",
        @Column(nullable = false) var state: String = "",
        @Column(nullable = false) var country: String = "",
)
