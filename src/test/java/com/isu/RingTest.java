package com.isu;

import com.isu.model.Discipline;
import com.isu.model.Ring;
import com.isu.repository.RingRepository;
import com.isu.service.interfaces.IRingService;
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
public class RingTest {

    @Autowired
    RingRepository ringRepository;

    @Autowired
    IRingService ringService;

    @Test
    public void dummy(){
    }

    @Test
    public void saveMarkTest(){
        Ring ring = new Ring();
        ring = ringService.create(ring);
        assertTrue(ring.getId()!=null);
    }

    @Test
    public void findDisciplineTest(){
        Ring ring = new Ring();
        Long testId = ringService.create(ring).getId();
        Ring ring2 = new Ring();
        Long testId2 = ringService.create(ring2).getId();
        List<Ring> rings = ringRepository.findAll();
        assertTrue(rings.stream().filter(f -> f.getId()
                .equals(testId)).findAny().isPresent());
        assertTrue(rings.stream().filter(f -> f.getId()
                .equals(testId2)).findAny().isPresent(  ));
    }

    @Test
    public void deleteDisciplineTest(){
        Ring ring = new Ring();
        ring = ringService.create(ring);
        assertTrue(ring.getId()!=null);
        ringService.delete(ring.getId());
    }


}
