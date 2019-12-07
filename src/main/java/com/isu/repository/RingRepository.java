package com.isu.repository;

import com.isu.model.Ring;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RingRepository extends CrudRepository<Ring, Long> {

    List<Ring> findAll();
}
