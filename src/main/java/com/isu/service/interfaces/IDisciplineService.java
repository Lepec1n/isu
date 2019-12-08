package com.isu.service.interfaces;

import com.isu.model.Discipline;

import java.util.List;

public interface IDisciplineService {

    List<Discipline> findAll();

    Discipline findById(Long disciplineId);

    Discipline findByName(String disciplineName);

    Discipline create(Discipline discipline);

    Discipline update(Discipline discipline);

    void delete(Discipline discipline);

    void delete(Long disciplineId);

}
