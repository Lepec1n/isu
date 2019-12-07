package com.isu.service;

import com.isu.model.Literature;
import com.isu.model.LiteratureRequest;
import com.isu.model.User;

import java.util.List;

public interface ILiteratureService {

    List<Literature> findAll();

    Literature findLiteratureByName(String name);

    LiteratureRequest createRequest(Literature literature, User user);

    LiteratureRequest leaveRequest(String literatureName, User user);

    Boolean processRequest(Long literatureRequestId);

    Literature addLiterature(String name, String preview);

    void removeLiterature(String name);

    void removeLiterature(Literature literature);

    Literature updateLiterature(Literature literature);
}
