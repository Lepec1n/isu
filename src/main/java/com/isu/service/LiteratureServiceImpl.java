package com.isu.service;

import com.isu.exception.LiteratureNotFoundException;
import com.isu.exception.RequestNotFoundException;
import com.isu.model.Literature;
import com.isu.model.LiteratureRequest;
import com.isu.model.User;
import com.isu.repository.LiteratureRepository;
import com.isu.repository.LiteratureRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
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
    public Literature findLiterature(Long id) {
        Optional<Literature> dbLiteratureContainer = literatureRepository.findById(id);
        if(!dbLiteratureContainer.isPresent())
            throw new LiteratureNotFoundException(id);
        return dbLiteratureContainer.get();
    }

    @Override
    public Literature findLiterature(String name) {
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
        return createRequest(findLiterature(literatureName), user);
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
    public Literature create(Literature literature) {
        literatureRepository.save(literature);
        return literature;
    }

    @Override
    public void delete(Long id) {
        Literature literature = findLiterature(id);
        delete(literature);
    }

    @Override
    public void delete(Literature literature) {
        if(!literature.getGivenOut())
            literatureRepository.delete(literature);
    }

    @Override
    public Literature update(Literature literature) {
        Literature dbLiterature = findLiterature(literature.getId());
        dbLiterature.setPreview(literature.getPreview());
        dbLiterature.setName(literature.getName());
        dbLiterature.setGivenOut(literature.getGivenOut());
        literatureRepository.save(dbLiterature);
        return dbLiterature;
    }
}
