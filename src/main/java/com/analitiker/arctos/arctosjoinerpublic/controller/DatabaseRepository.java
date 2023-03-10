package com.analitiker.arctos.arctosjoinerpublic.controller;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface DatabaseRepository extends CrudRepository<UserEntity, Long> {
    List<UserEntity> findAll();
}
