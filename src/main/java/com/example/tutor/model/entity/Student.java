package com.example.tutor.model.entity;

import com.example.tutor.model.enums.Grade;
import com.google.gson.Gson;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter

@Entity(name = "studentEntity")
@DiscriminatorValue("Student")
@jakarta.inject.Named
@ApplicationScoped

public class Student extends User {
    @Enumerated(EnumType.ORDINAL)
    private Grade grade;

    public Student(String name, String family, String username, String password, Role role, Grade grade/*, Celass celass*/) {
        super(name, family, username, password, role);
        this.grade = grade;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
