package com.example.demo.common;

import java.util.List;

public interface BaseMongoRepository<E> {
    List<E> findAll();
    E findById(String id);
}
