package com.isu.repository;

import com.isu.model.Group;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GroupRepository extends CrudRepository<Group, Long> {

    List<Group> findAll();

}

