    package com.example.graduateWork.entity;

    import lombok.AllArgsConstructor;
    import lombok.Data;
    import lombok.NoArgsConstructor;

    import javax.persistence.*;
    import javax.validation.Valid;
    import javax.validation.constraints.*;

    @Valid
    @Entity
    @Table(name = "users")
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class Users {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id_user")
        private Long idUser;

        @NotNull(message = "Please enter phone number")
        @DecimalMin(value = "10000000000", message = "Phone number must be exactly 11 digits")
        @DecimalMax(value = "99999999999", message = "Phone number must be exactly 11 digits")
        @Column(name = "phone_number")
        private Long phoneNumber;

        @NotNull(message = "Please enter password")
        @Column(name = "password")
        private String password;

        @Column(name = "role")
        @Enumerated(EnumType.STRING)
        private Role role;
    }
