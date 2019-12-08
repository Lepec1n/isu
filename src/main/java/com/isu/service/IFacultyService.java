package com.isu.service;

import com.isu.model.Faculty;
import com.isu.model.Ring;

import java.util.List;

public interface IFacultyService {

    List<Faculty> findAll();

    Faculty findById(Long faculty_id);

    Faculty create(Faculty faculty);

    Faculty update(Faculty faculty);

    void delete(Long faculty_id);

    void delete(Faculty faculty);
}
