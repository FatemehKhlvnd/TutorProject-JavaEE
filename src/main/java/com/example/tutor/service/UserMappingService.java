package com.example.tutor.service;

import com.example.tutor.model.entity.UserMapping;

import java.util.List;
import java.util.Optional;

public interface UserMappingService {
    void save(UserMapping attach) throws Exception;

    void edit(UserMapping attach) throws Exception;

    void remove(UserMapping attach) throws Exception;

    void removeById(Long id) throws Exception;

    List<UserMapping> findAll() throws Exception;

    Optional<UserMapping> findById(Long id) throws Exception;
}
