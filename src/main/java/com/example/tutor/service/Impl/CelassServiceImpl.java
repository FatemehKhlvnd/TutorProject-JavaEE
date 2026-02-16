
package com.example.tutor.service.Impl;

import com.example.tutor.model.entity.Celass;
import com.example.tutor.model.entity.Student;
import com.example.tutor.model.entity.Teacher;
import com.example.tutor.service.CelassService;
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
public class CelassServiceImpl implements CelassService, Serializable {
    @PersistenceContext(unitName = "tutor")
    private EntityManager entityManager;

    @Transactional
    @Override
    public void save(Celass attach) throws Exception {
        entityManager.persist(attach);
    }

    @Transactional
    @Override
    public void edit(Celass attach) throws Exception {
        entityManager.merge(attach);
    }

    @Transactional
    @Override
    public void remove(Celass attach) throws Exception {
        entityManager.remove(attach);
    }

    @Transactional
    @Override
    public void removeById(Long id) throws Exception {
        Celass attach = entityManager.find(Celass.class, id);
        entityManager.remove(attach);
    }

    @Transactional
    @Override
    public List<Celass> findAll() throws Exception {
        TypedQuery<Celass> query = entityManager.createQuery("select p from celassEntity p", Celass.class);
        return query.getResultList();
    }

    @Transactional
    @Override
    public Optional<Celass> findById(Long id) throws Exception {
        return Optional.ofNullable(entityManager.find(Celass.class, id));
    }
    @Transactional
    @Override
    public List<Celass> findByStudentUsername(String username) throws Exception {

        Student student=entityManager.find(Student.class,username);
        TypedQuery<Celass> query=entityManager.createQuery("SELECT oo FROM celassEntity oo WHERE oo.student=:student",Celass.class);
        query.setParameter("student",student);
        return query.getResultList();
    }
    @Transactional
    @Override
    public List<Celass> findByTeacherUsername(String username) throws Exception {

        Teacher teacher=entityManager.find(Teacher.class,username);
        TypedQuery<Celass> query=entityManager.createQuery("SELECT oo FROM celassEntity oo WHERE oo.teacher=:teacher",Celass.class);
        query.setParameter("teacher",teacher);
        return query.getResultList();
    }
}
