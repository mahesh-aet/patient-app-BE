package com.patient.patient_app.model;

import jakarta.persistence.*;
import lombok.*;
;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String address;
    private String city;
    private String state;
    @Column(name = "zip_code")
    private String zipCode;
    @Column(name = "phone_number", unique = true)
    private String phoneNumber;
    @Column(name="email",unique = true)
    private String email;
}
