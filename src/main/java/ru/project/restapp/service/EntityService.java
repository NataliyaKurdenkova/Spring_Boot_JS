package ru.project.restapp.service;

import java.util.List;
import java.util.Optional;

public interface EntityService<E> {
    void save(E entity);
    void delete(Long id);
    void update(E entity);
    List<E> findAll();
    Optional<E> findById(Long id);
    Optional<E> findByName(String name);


}