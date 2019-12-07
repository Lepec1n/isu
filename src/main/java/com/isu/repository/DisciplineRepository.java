package com.isu.repository;

import com.isu.model.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DisciplineRepository extends JpaRepository<Discipline, Long> {

    List<Discipline> findAll();

    Optional<Discipline> findDisciplineByName(String name);
}
