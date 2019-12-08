package com.isu;


import com.isu.configuration.TestConfiguration;
import com.isu.model.Faculty;
import com.isu.repository.FacultyRepository;
import com.isu.service.interfaces.IFacultyService;
import org.junit.Test;


import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfiguration.class})
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

}
