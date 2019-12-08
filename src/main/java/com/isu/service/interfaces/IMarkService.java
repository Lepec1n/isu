package com.isu.service.interfaces;

import com.isu.model.Mark;

import java.util.List;

public interface IMarkService {

    List<Mark> findAll();

    Mark findById(Long markId);

    Mark create(Mark mark);

    Mark update(Mark mark);

    void delete(Mark mark);

    void delete(Long markId);

}
