package com.example.demo.entity;

import lombok.Data;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Data
@Embeddable
public class Address {
    @Column(nullable = false)
    private String street;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String zipcode;

    @Column(nullable = false)
    private String country;
}
