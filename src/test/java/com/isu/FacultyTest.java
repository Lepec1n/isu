package com.isu;

import com.isu.model.Faculty;
import com.isu.repository.FacultyRepository;
import com.isu.service.interfaces.IFacultyService;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class FacultyTest {

    @Autowired
    FacultyRepository facultyRepository;

    @Autowired
    IFacultyService facultyService;

    @Test
    public void dummy(){
    }

    @Test
    public void saveFacultyTest(){
        Faculty testFaculty = new Faculty();
        testFaculty.setName("Absolutely original faculty name");
        testFaculty = facultyService.create(testFaculty);
        assertTrue(testFaculty.getId()!=null);
    }

    @Test
    public void findFacultyTest(){
        Faculty testFaculty = new Faculty();
        testFaculty.setName("Absolutely original faculty name");
        Long testId = facultyService.create(testFaculty).getId();
        Faculty testFaculty2 = new Faculty();
        testFaculty2.setName("Absolutely original faculty name#2");
        Long testId2 = facultyService.create(testFaculty2).getId();
        List<Faculty> faculties = facultyRepository.findAll();
        assertTrue(faculties.stream().filter(f -> f.getId()
                .equals(testId)).findAny().isPresent());
        assertTrue(faculties.stream().filter(f -> f.getId()
                .equals(testId2)).findAny().isPresent());
    }

}
