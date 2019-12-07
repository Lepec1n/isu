package com.isu.service;

import com.isu.exception.LiteratureNotFoundException;
import com.isu.exception.RequestNotFoundException;
import com.isu.model.Literature;
import com.isu.model.LiteratureRequest;
import com.isu.model.User;
import com.isu.repository.LiteratureRepository;
import com.isu.repository.LiteratureRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class LiteratureServiceImpl implements ILiteratureService {

    private static final Boolean GIVEN_OUT = true;

    @Autowired
    LiteratureRepository literatureRepository;
    @Autowired
    LiteratureRequestRepository literatureRequestRepository;

    @Override
    public List<Literature> findAll() {
        return literatureRepository.findAll();
    }

    @Override
    public Literature findLiteratureByName(String name) {
        return literatureRepository.findLiteratureByName(name);
    }

    @Override
    public LiteratureRequest createRequest(Literature literature, User user) {
        LiteratureRequest request = new LiteratureRequest();
        request.setLiterature(literature);
        request.setUser(user);
        literatureRequestRepository.save(request);
        return request;
    }

    @Override
    public LiteratureRequest leaveRequest(String literatureName, User user) {
        return createRequest(findLiteratureByName(literatureName), user);
    }

    @Override
    public Boolean processRequest(Long literatureRequestId) {
        Optional<LiteratureRequest> literatureRequestContainer = literatureRequestRepository.findById(literatureRequestId);
        if(!literatureRequestContainer.isPresent())
            throw new RequestNotFoundException(literatureRequestId);
        else {
            LiteratureRequest literatureRequest = literatureRequestContainer.get();
            literatureRequest.getLiterature().setGivenOut(GIVEN_OUT);
            return GIVEN_OUT;
        }
    }

    @Override
    public Literature addLiterature(String name, String preview) {
        Literature literature = new Literature();
        literature.setName(name);
        literature.setPreview(preview);
        literatureRepository.save(literature);
        return literature;
    }

    @Override
    public void removeLiterature(String name) {
        Literature literature = literatureRepository.findLiteratureByName(name);
        removeLiterature(literature);
    }

    @Override
    public void removeLiterature(Literature literature) {
        if(!literature.getGivenOut())
            literatureRepository.delete(literature);
    }

    @Override
    public Literature updateLiterature(Literature literature) {
        Optional<Literature> dbLiteratureContainer = literatureRepository.findById(literature.getId());
        if(!dbLiteratureContainer.isPresent())
            throw new LiteratureNotFoundException(literature.getId());
        Literature dbLiterature = dbLiteratureContainer.get();
        dbLiterature.setPreview(literature.getPreview());
        dbLiterature.setName(literature.getName());
        dbLiterature.setGivenOut(literature.getGivenOut());
        literatureRepository.save(dbLiterature);
        return dbLiterature;
    }
}
