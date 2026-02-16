package com.example.tutor.service;

import com.example.tutor.model.entity.Teacher;

import java.util.List;
import java.util.Optional;

public interface TeacherService {
    void save(Teacher attach) throws Exception;

    void edit(Teacher attach) throws Exception;

    void remove(Teacher attach) throws Exception;

    void removeById(Long id) throws Exception;

    List<Teacher> findAll() throws Exception;

    Optional<Teacher> findById(Long id) throws Exception;
    Optional<Teacher> findByName(String name) throws Exception;

    Optional<Teacher> findTeacherByLesson(Long id) throws Exception;

}
