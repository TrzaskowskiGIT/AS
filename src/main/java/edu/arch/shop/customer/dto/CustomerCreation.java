package edu.arch.shop.customer.dto;

import jakarta.persistence.Column;

import java.math.BigDecimal;

public record CustomerCreation(

        String firstName;
        String lastName;
        String email;
        String phoneNumber;
) {
}
