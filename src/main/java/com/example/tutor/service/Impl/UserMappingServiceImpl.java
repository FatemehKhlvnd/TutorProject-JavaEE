package com.example.tutor.service.Impl;


import com.example.tutor.model.entity.UserMapping;
import com.example.tutor.service.UserMappingService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;


@Slf4j
@ApplicationScoped
public class UserMappingServiceImpl implements UserMappingService {
    @PersistenceContext(unitName = "tutor")
    private EntityManager entityManager;

    @Transactional
    @Override
    public void save(UserMapping attach) throws Exception {
        entityManager.merge(attach);
    }

    @Transactional
    @Override
    public void edit(UserMapping attach) throws Exception {
        entityManager.merge(attach);
    }

    @Transactional
    @Override
    public void remove(UserMapping attach) throws Exception {
        entityManager.remove(attach);
    }

    @Transactional
    @Override
    public void removeById(Long id) throws Exception {
        UserMapping attach = entityManager.find(UserMapping.class, id);
        entityManager.remove(attach);
    }

    @Transactional
    @Override
    public List<UserMapping> findAll() throws Exception {
        TypedQuery<UserMapping> query = entityManager.createQuery("select p from userMappingEntity p", UserMapping.class);
        return query.getResultList();
    }

    @Transactional
    @Override
    public Optional<UserMapping> findById(Long id) throws Exception {
        return Optional.ofNullable(entityManager.find(UserMapping.class, id));
    }
}
