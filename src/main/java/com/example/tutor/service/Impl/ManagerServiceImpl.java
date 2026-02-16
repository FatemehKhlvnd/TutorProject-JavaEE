package com.example.tutor.service.Impl;

import com.example.tutor.model.entity.Manager;
import com.example.tutor.service.ManagerService;
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
public class ManagerServiceImpl implements ManagerService, Serializable {
    @PersistenceContext(unitName = "tutor")
    private EntityManager entityManager;


    @Transactional
    @Override
    public void save(Manager attach) throws Exception {
        entityManager.persist(attach);
    }


    @Transactional
    @Override
    public void edit(Manager attach) throws Exception {
        entityManager.merge(attach);
    }

    @Transactional
    @Override
    public void remove(Manager attach) throws Exception {
        entityManager.remove(attach);
    }

    @Transactional
    @Override
    public void removeById(Long id) throws Exception {
        Manager attach = entityManager.find(Manager.class, id);
        entityManager.remove(attach);
    }

    @Transactional
    @Override
    public List<Manager> findAll() throws Exception {
        TypedQuery<Manager> query = entityManager.createQuery("select p from managerEntity p", Manager.class);
        return query.getResultList();
    }

    @Transactional
    @Override
    public Optional<Manager> findById(Long id) throws Exception {
        return Optional.ofNullable(entityManager.find(Manager.class, id));
    }
}
