package com.example.tutor.service;

import com.example.tutor.model.entity.Celass;

import java.util.List;
import java.util.Optional;

public interface CelassService {
    void save(Celass attach) throws Exception;

    void edit(Celass attach) throws Exception;

    void remove(Celass attach) throws Exception;

    void removeById(Long id) throws Exception;

    List<Celass> findAll() throws Exception;

    Optional<Celass> findById(Long id) throws Exception;
//    Optional<Celass> findByStudent(Student student) throws Exception;

    List<Celass> findByStudentUsername(String username) throws Exception;
    List<Celass> findByTeacherUsername(String username) throws Exception;
}