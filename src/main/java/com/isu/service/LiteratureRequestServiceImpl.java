package com.isu.service;


import com.isu.exception.RequestNotFoundException;
import com.isu.model.LiteratureRequest;
import com.isu.repository.LiteratureRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LiteratureRequestServiceImpl implements ILiteratureRequestService{


    @Autowired
    LiteratureRequestRepository literatureRequestRepository;

    @Override
    public List<LiteratureRequest> findAll() {
        return literatureRequestRepository.findAll();
    }

    @Override
    public LiteratureRequest findById(Long literatureRequestId) {
        Optional<LiteratureRequest> dbRequestContainer =
                literatureRequestRepository.findById(literatureRequestId);
        if(!dbRequestContainer.isPresent())
            throw new RequestNotFoundException(literatureRequestId);
        return dbRequestContainer.get();
    }

    @Override
    public LiteratureRequest create(LiteratureRequest literatureRequest) {
        literatureRequestRepository.save(literatureRequest);
        return literatureRequest;
    }

    @Override
    public LiteratureRequest update(LiteratureRequest literatureRequest) {
        LiteratureRequest request = findById(literatureRequest.getId());
        request.setUser(literatureRequest.getUser());
        request.setLiterature(literatureRequest.getLiterature());
        literatureRequestRepository.save(request);
        return request;
    }

    @Override
    public void delete(LiteratureRequest request) {
        literatureRequestRepository.delete(request);
    }

    @Override
    public void delete(Long literatureRequestId) {
        LiteratureRequest literatureRequest = findById(literatureRequestId);
        delete(literatureRequest);
    }
}
