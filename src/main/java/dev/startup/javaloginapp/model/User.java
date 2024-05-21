package dev.startup.javaloginapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,unique = true,length = 45)
    private String email;
    @Column(nullable = false,length = 20)
    private String firstName;
    private String lastName;
    @Column(nullable = false,length = 64 )
    private String password;

}
