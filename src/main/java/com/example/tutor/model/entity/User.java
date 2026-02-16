package com.example.tutor.model.entity;

import com.google.gson.Gson;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@Getter
@Setter

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_type", discriminatorType = DiscriminatorType.STRING)
@MappedSuperclass
public abstract class User {
    @Id
    @Column(name = "u_username", length = 20)
    @Pattern(regexp = "^[a-zA-Z\\s]{2,20}$", message = "Name is Not Valid")
    private String username;

    @Column(name = "u_name", length = 20)
    @Pattern(regexp = "^[a-zA-Z\\s]{2,20}$", message = "Name is Not Valid")
    private String name;

    @Column(name = "u_family", length = 20)
    private String family;


    @Column(name = "u_password", length = 20)
    private String password;

    @OneToOne
    private Role role;

    @ManyToOne
    @JoinColumn(name = "user_mapping_id")
    private UserMapping userMapping;

    public User(String name, String family, String username, String password, Role role) {
        this.name = name;
        this.family = family;
        this.username = username;
        this.password = password;
        this.role = role;
    }
    public User(Role role) {
        this.role = role;
    }
    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}