package com.kandid.backend.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "contact_us_form")
public class ContactUsForm {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Getter @Setter
    private String name;

    @Getter @Setter
    private String email;

    @Getter @Setter
    private String phone;

    @Getter @Setter
    private String message;
}