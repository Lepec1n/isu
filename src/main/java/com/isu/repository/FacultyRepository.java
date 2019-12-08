package com.isu.repository;

import com.isu.model.Discipline;
import com.isu.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {

    List<Faculty> findAll();

    Optional<Faculty> findFacultiesByName(String name);
}
