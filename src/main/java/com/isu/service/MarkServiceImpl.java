package com.isu.service;


import com.isu.exception.MarkNotFoundException;
import com.isu.model.Mark;
import com.isu.repository.MarkRepository;
import com.isu.service.interfaces.IMarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarkServiceImpl implements IMarkService {

    @Autowired
    MarkRepository markRepository;


    @Override
    public List<Mark> findAll() {
        return markRepository.findAll();
    }

    @Override
    public Mark findById(Long markId) {
        Optional<Mark> dbMarkContainer = markRepository.findById(markId);
        if(!dbMarkContainer.isPresent())
            throw new MarkNotFoundException(markId);
        return dbMarkContainer.get();
    }

    @Override
    public Mark create(Mark mark) {
        markRepository.save(mark);
        return mark;
    }

    @Override
    public Mark update(Mark mark) {
        Mark dbMark = findById(mark.getId());
        dbMark.setDiscipline(mark.getDiscipline());
        dbMark.setMark(mark.getMark());
        dbMark.setUser(mark.getUser());
        markRepository.save(dbMark);
        return dbMark;
    }

    @Override
    public void delete(Mark mark) {
        markRepository.delete(mark);
    }

    @Override
    public void delete(Long markId) {
        Mark dbMark = findById(markId);
        delete(dbMark);
    }
}
