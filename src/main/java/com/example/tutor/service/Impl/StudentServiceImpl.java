package com.example.tutor.service.Impl;

import com.example.tutor.model.entity.Student;
import com.example.tutor.service.StudentService;
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
public class StudentServiceImpl implements StudentService, Serializable {
    @PersistenceContext(unitName = "tutor")
    private EntityManager entityManager;


    @Transactional
    @Override
    public void save(Student attach) throws Exception {
        entityManager.merge(attach);
    }

    @Transactional
    @Override
    public void edit(Student attach) throws Exception {
        entityManager.merge(attach);
    }

    @Transactional
    @Override
    public void remove(Student attach) throws Exception {
        entityManager.remove(attach);
    }

    @Transactional
    @Override
    public void removeById(Long id) throws Exception {
        Student attach = entityManager.find(Student.class, id);
        entityManager.remove(attach);
    }

    @Transactional
    @Override
    public List<Student> findAll() throws Exception {
        TypedQuery<Student> query = entityManager.createQuery("select p from studentEntity p", Student.class);
        return query.getResultList();
    }

    @Transactional
    @Override
    public Optional<Student> findById(Long id) throws Exception {
        return Optional.ofNullable(entityManager.find(Student.class, id));
    }
}
