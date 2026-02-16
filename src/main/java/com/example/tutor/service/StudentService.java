package com.example.tutor.service;

import com.example.tutor.model.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    void save(Student attach) throws Exception;

    void edit(Student attach) throws Exception;

    void remove(Student attach) throws Exception;

    void removeById(Long id) throws Exception;

    List<Student> findAll() throws Exception;

    Optional<Student> findById(Long id) throws Exception;
}
