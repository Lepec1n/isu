package com.isu;

import com.isu.model.Discipline;
import com.isu.model.Faculty;
import com.isu.repository.DisciplineRepository;
import com.isu.service.interfaces.IDisciplineService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class DisciplineTest {

    @Autowired
    DisciplineRepository disciplineRepository;

    @Autowired
    IDisciplineService disciplineService;

    @Test
    public void dummy(){
    }

    @Test
    public void saveDisciplineTest(){
        Discipline discipline = new Discipline();
        discipline.setName("Absolutely original discipline name");
        discipline = disciplineService.create(discipline);
        assertTrue(discipline.getId()!=null);
    }

    @Test
    public void findDisciplineTest(){
        Discipline discipline = new Discipline();
        discipline.setName("Absolutely original discipline name");
        Long testId = disciplineService.create(discipline).getId();
        Discipline discipline2 = new Discipline();
        discipline2.setName("Absolutely original discipline name#2");
        Long testId2 = disciplineService.create(discipline2).getId();
        List<Discipline> disciplines = disciplineRepository.findAll();
        assertTrue(disciplines.stream().filter(f -> f.getId()
                .equals(testId)).findAny().isPresent());
        assertTrue(disciplines.stream().filter(f -> f.getId()
                .equals(testId2)).findAny().isPresent(  ));
    }

    @Test
    public void deleteDisciplineTest(){
        Discipline discipline = new Discipline();
        discipline.setName("Absolutely original faculty name");
        discipline = disciplineService.create(discipline);
        assertTrue(discipline.getId()!=null);
        disciplineService.delete(discipline.getId());
    }


}
