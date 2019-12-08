package com.isu.service;

import com.isu.model.Faculty;
import com.isu.repository.FacultyRepository;
import com.isu.service.interfaces.IFacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class FacultyServiceImpl implements IFacultyService {

    @Autowired
    FacultyRepository facultyRepository;

    @Override
    public List<Faculty> findAll() {
        return facultyRepository.findAll();
    }

    @Override
    public Faculty findById(Long faculty_id) {
        Optional<Faculty> dbFacultyContainer = facultyRepository.findById(faculty_id);
        if(!dbFacultyContainer.isPresent());
        return dbFacultyContainer.get();
    }

    @Override
    public Faculty create(Faculty faculty) {
        facultyRepository.save(faculty);
        return faculty;
    }

    @Override
    public Faculty update(Faculty faculty) {
        Faculty dbFaculty = findById(faculty.getId());
        dbFaculty.setName(faculty.getName());
        facultyRepository.save(dbFaculty);
        return dbFaculty;
    }

    @Override
    public void delete(Long faculty_id) {
        Faculty dbFaculty = findById(faculty_id);
        delete(dbFaculty);
    }

    @Override
    public void delete(Faculty faculty) {
        facultyRepository.delete(faculty);
    }
}
