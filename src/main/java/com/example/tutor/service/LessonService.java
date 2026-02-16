package com.example.tutor.service;

import com.example.tutor.model.entity.Lesson;

import java.util.List;
import java.util.Optional;

public interface LessonService {
    void save(Lesson attach) throws Exception;

    void edit(Lesson attach) throws Exception;

    void remove(Lesson attach) throws Exception;

    void removeById(Long id) throws Exception;

    List<Lesson> findAll() throws Exception;

    Optional<Lesson> findById(Long id) throws Exception;
}
