package com.example.tutor.service;


import com.example.tutor.model.entity.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    void save(Role attach) throws Exception;

    void edit(Role attach) throws Exception;

    void remove(Role attach) throws Exception;

    void removeById(Long id) throws Exception;

    List<Role> findAll() throws Exception;

    Optional<Role> findById(Long id) throws Exception;

    Role findByName(String role) throws Exception;
}
