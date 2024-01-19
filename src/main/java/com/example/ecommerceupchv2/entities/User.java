package com.example.ecommerceupchv2.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;
//import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, length = 50)
    private String email;

    @Column(length = 100)
    private String password;

    @Column(length = 40)
    private String firstName;

    @Column(length = 40)
    private String lastName;

    //@Column(TemporalType.DATE)
    private Date dateOfBirth;

    /*@OneToMany(mappedBy = "user")
    private List<User> user;*/

}
