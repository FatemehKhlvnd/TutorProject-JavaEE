package com.example.tutor.model.entity;

import com.google.gson.Gson;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder

@Entity(name = "roleEntity")
@Table(name = "role_tbl")
@jakarta.inject.Named
@ApplicationScoped
public class Role {
    @Id
    @Pattern(regexp = "^[a-zA-Z\\s]{3,30}$", message = "Invalid Role")
    @Column(name = "r_role", length = 30, nullable = false)
    private String role;


    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
