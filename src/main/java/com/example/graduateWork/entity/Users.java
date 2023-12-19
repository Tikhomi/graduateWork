    package com.example.graduateWork.entity;

    import lombok.AllArgsConstructor;
    import lombok.Data;
    import lombok.NoArgsConstructor;

    import javax.persistence.*;


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

        @Column(name = "phone_number")
        private String phoneNumber;

        @Column(name = "password")
        private String password;

        @Column(name = "role")
        @Enumerated(EnumType.STRING)
        private Role role;



    }
