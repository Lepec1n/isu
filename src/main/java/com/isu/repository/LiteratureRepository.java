package com.isu.repository;

import com.isu.model.Literature;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LiteratureRepository extends JpaRepository<Literature, Long> {

    List<Literature> findAll();
}