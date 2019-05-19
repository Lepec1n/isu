package com.isu.repository;

import com.isu.model.Status;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StatusRepository extends CrudRepository<Status, Long> {

    List<Status> findAll();
}

