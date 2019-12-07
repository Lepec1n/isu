package com.isu.service;

import com.isu.exception.DisciplineNameNotFoundException;
import com.isu.exception.DisciplineNotFoundException;
import com.isu.model.Discipline;
import com.isu.repository.DisciplineRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class DisciplineServiceImpl implements IDisciplineService{

    @Autowired
    DisciplineRepository disciplineRepository;

    @Override
    public List<Discipline> findAll() {
        return disciplineRepository.findAll();
    }

    @Override
    public Discipline findById(Long disciplineId) {
        Optional<Discipline> dbDisciplineContainer = disciplineRepository.findById(disciplineId);
        if(!dbDisciplineContainer.isPresent())
            throw new DisciplineNotFoundException(disciplineId);
        return dbDisciplineContainer.get();
    }

    @Override
    public Discipline findByName(String disciplineName) {
        Optional<Discipline> dbDisciplineContainer = disciplineRepository
                .findDisciplineByName(disciplineName);
        if(!dbDisciplineContainer.isPresent())
            throw new DisciplineNameNotFoundException(disciplineName);
        return dbDisciplineContainer.get();
    }

    @Override
    public Discipline create(Discipline discipline) {
        disciplineRepository.save(discipline);
        return discipline;
    }

    @Override
    public Discipline update(Discipline discipline) {
        Discipline dbDiscipline = findById(discipline.getId());
        dbDiscipline.setName(dbDiscipline.getName());
        disciplineRepository.save(dbDiscipline);
        return dbDiscipline;
    }

    @Override
    public void delete(Discipline discipline) {
        Discipline dbDiscipline = findById(discipline.getId());
        disciplineRepository.delete(dbDiscipline);
    }

    @Override
    public void delete(Long disciplineId) {
        Discipline dbDiscipline = findById(disciplineId);
        disciplineRepository.delete(dbDiscipline);
    }
}
