package com.isu.service.interfaces;

import com.isu.model.Literature;
import com.isu.model.LiteratureRequest;
import com.isu.model.User;

import java.util.List;

public interface ILiteratureService {

    List<Literature> findAll();

    Literature findLiterature(Long id);

    Literature findLiterature(String name);

    List<Literature> searchLiterature(String name);

    LiteratureRequest createRequest(Literature literature, User user);

    LiteratureRequest leaveRequest(String literatureName, User user);

    Boolean processRequest(Long literatureRequestId);

    Literature create(Literature literature);

    void delete(Long id);

    void delete(Literature literature);

    Literature update(Literature literature);
}
