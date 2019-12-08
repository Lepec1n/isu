package com.isu.service;

import com.isu.model.Discipline;
import com.isu.model.LiteratureRequest;

import java.util.List;

public interface ILiteratureRequestService {

    List<LiteratureRequest> findAll();

    LiteratureRequest findById(Long literatureRequestId);

    LiteratureRequest create(LiteratureRequest literatureRequest);

    LiteratureRequest update(LiteratureRequest literatureRequest);

    void delete(LiteratureRequest discipline);

    void delete(Long literatureRequestId);

}
