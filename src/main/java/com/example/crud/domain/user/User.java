package com.example.crud.domain.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.UUID;

@Table(name = "users")
@Entity(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;
    @NotBlank
    String name;
    @NotBlank
    String email;
    @NotNull
    Integer age;

    public User(PostRequestUser requestUser){
        this.name = requestUser.name();
        this.email = requestUser.email();
        this.age = requestUser.age();
    }

    public User(PutRequestUser requestUser){
        this.name = requestUser.name();
        this.email = requestUser.email();
        this.age = requestUser.age();
    }
}
