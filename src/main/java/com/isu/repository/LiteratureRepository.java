package com.isu.repository;

import com.isu.model.Literature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LiteratureRepository extends JpaRepository<Literature, Long> {

    List<Literature> findAll();

    Literature findLiteratureByName(String name);

    List<Literature> findAllByNameContains(String name);
}
