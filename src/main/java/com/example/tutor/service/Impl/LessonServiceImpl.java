package com.example.tutor.service.Impl;

import com.example.tutor.model.entity.Lesson;
import com.example.tutor.service.LessonService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;


@Slf4j
@SessionScoped
public class LessonServiceImpl implements LessonService, Serializable {
    @PersistenceContext(unitName = "tutor")
    private EntityManager entityManager;


    @Transactional
    @Override
    public void save(Lesson attach) throws Exception {
        entityManager.persist(attach);
    }


    @Transactional
    @Override
    public void edit(Lesson attach) throws Exception {
        entityManager.merge(attach);
    }


    @Transactional
    @Override
    public void remove(Lesson attach) throws Exception {
        entityManager.remove(attach);
    }


    @Transactional
    @Override
    public void removeById(Long id) throws Exception {
        Lesson attach = entityManager.find(Lesson.class, id);
        entityManager.remove(attach);
    }


    @Transactional
    @Override
    public List<Lesson> findAll() throws Exception {
        TypedQuery<Lesson> query = entityManager.createQuery("select p from lessonEntity p", Lesson.class);
        return query.getResultList();
    }


    @Transactional
    @Override
    public Optional<Lesson> findById(Long id) throws Exception {
        return Optional.ofNullable(entityManager.find(Lesson.class, id));
    }
}
