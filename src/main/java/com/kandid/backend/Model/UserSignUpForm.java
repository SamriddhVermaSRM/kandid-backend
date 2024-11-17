package com.kandid.backend.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Entity
@Table(name = "user_sign_up_form")
public class UserSignUpForm {
    @Getter @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Getter @Setter
    private String name;

    @Getter @Setter
    private String email;

    @Getter @Setter
    @Column(name = "phone_number")
    private String phone;

    @Getter @Setter
    private String location;

    @Getter @Setter
    private String message;

    @Getter
    private boolean student;

    public void setStudent(String student) {
        this.student = Objects.equals(student, "true");
    }

    @Getter @Setter
    @Column(name = "college_name")
    private String college;
}
