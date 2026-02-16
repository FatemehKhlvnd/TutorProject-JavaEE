package com.example.tutor.service;

import com.example.tutor.model.entity.Manager;

import java.util.List;
import java.util.Optional;

public interface ManagerService {
    void save(Manager attach) throws Exception;

    void edit(Manager attach) throws Exception;

    void remove(Manager attach) throws Exception;

    void removeById(Long id) throws Exception;

    List<Manager> findAll() throws Exception;

    Optional<Manager> findById(Long id) throws Exception;
}
