package com.example.tutor.model.entity;

import com.google.gson.Gson;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter


@Entity(name = "managerEntity")
@DiscriminatorValue("Manager")
@jakarta.inject.Named
@ApplicationScoped

public class Manager extends User {

    @OneToMany(fetch = FetchType.EAGER)
    private List<Celass> celasses = new ArrayList<>();

    public Manager(String name, String family, String username, String password, Role role, List<Celass> celasses/*, List<Lesson> lessons, List<Student> students*/) {
        super(name, family, username, password, role);
        this.celasses = celasses;

    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
