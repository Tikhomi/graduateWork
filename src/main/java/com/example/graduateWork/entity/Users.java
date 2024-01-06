    package com.example.graduateWork.entity;

    import lombok.AllArgsConstructor;
    import lombok.Data;
    import lombok.NoArgsConstructor;
    import org.hibernate.validator.constraints.NotEmpty;

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
        private Long id_user;

        @NotNull(message = "Please enter phone number")
        @DecimalMin(value = "10000000000", message = "Phone number must be exactly 11 digits")
        @DecimalMax(value = "99999999999", message = "Phone number must be exactly 11 digits")
        @Column(name = "phone_number")
        private Long phoneNumber;

        //@Size(min = 3, max = 10)
        //@Size(max = 20, min = 3, message = "{user.name.invalid}")
        //@NotNull(message = "Please enter password")
//        @Pattern(regexp="\\d{6}")
//        @NotBlank(message = "Please enter a password")
//        @NotEmpty(message = "Password cannot be empty")

        @NotNull(message = "dfsdfsdf")
        @Column(name = "password"/*, nullable = false*/)
        private String password;

        @Column(name = "role")
        @Enumerated(EnumType.STRING)
        private Role role;
    }
