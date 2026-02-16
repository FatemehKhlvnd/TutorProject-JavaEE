package com.example.tutor.service.Impl;

import com.example.tutor.model.entity.Role;
import com.example.tutor.service.RoleService;
import jakarta.enterprise.context.SessionScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Slf4j
@SessionScoped
public class RoleServiceImpl implements RoleService, Serializable {

    @PersistenceContext(unitName = "tutor")
    private EntityManager entityManager;

    @Transactional
    @Override
    public void save(Role role) throws Exception {
        entityManager.persist(role);
    }


    @Transactional
    @Override
    public void edit(Role attach) throws Exception {
        entityManager.merge(attach);
    }

    @Transactional
    @Override
    public void remove(Role attach) throws Exception {
        entityManager.remove(attach);
    }

    @Transactional
    @Override
    public void removeById(Long id) throws Exception {
        Role attach = entityManager.find(Role.class, id);
        entityManager.remove(attach);
    }

    @Transactional
    @Override
    public List<Role> findAll() throws Exception {
        TypedQuery<Role> query = entityManager.createQuery("select p from roleEntity p", Role.class);
        return query.getResultList();
    }

    @Transactional
    @Override
    public Optional<Role> findById(Long id) throws Exception {
        return Optional.ofNullable(entityManager.find(Role.class, id));
    }

    @Transactional
    @Override
    public Role findByName(String roleName) throws Exception {
        try {
            // Use JPQL (Java Persistence Query Language) to create a query
            String jpql = "SELECT r FROM roleEntity r WHERE r.role = :roleName";
            return entityManager.createQuery(jpql, Role.class)
                    .setParameter("roleName", roleName)
                    .getSingleResult();
        } catch (NoResultException e) {
            // If no result is found, you might want to handle this case appropriately
            // For now, we're returning null, but you might throw an exception or return a default role
            return null;
        } catch (Exception e) {
            throw new RuntimeException("Error occurred while fetching Role by name", e);
        }
    }
}
