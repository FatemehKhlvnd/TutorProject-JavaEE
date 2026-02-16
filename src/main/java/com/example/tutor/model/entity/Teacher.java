package com.example.tutor.model.entity;

import com.google.gson.Gson;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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


@Entity(name = "teacherEntity")
@DiscriminatorValue("Teacher")

@jakarta.inject.Named
@ApplicationScoped
public class Teacher extends User {

    @Column(name = "t_education", length = 20)
    private String education;

    @Column(name = "t_specification", length = 250)
    private String specification;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Celass> celasses ;

    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private Lesson lesson;

    public Teacher(String name, String family, String username, String password, Role role, String education, String specification,/* List<Celass> celasses,*/ Lesson lesson) {
        super(name, family, username, password, role);
        this.education = education;
        this.specification = specification;
        //this.celasses = celasses;
        this.lesson = lesson;
    }

    public void addCelass(Celass celass) {
        if (celasses == null){
            celasses = new ArrayList<>();
        }
        celasses.add(celass);
    }


    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
