package com.isu.service;


import com.isu.exception.StatusNotFoundException;
import com.isu.model.Status;
import com.isu.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatusService implements IStatusService {

    @Autowired
    StatusRepository statusRepository;

    @Override
    public List<Status> getStatuses() {
        return statusRepository.findAll();
    }

    @Override
    public Status findStatusById(long id) {

        Optional<Status> dbStatusContainer = statusRepository.findById(id);
        if(!dbStatusContainer.isPresent())
            throw new StatusNotFoundException();
        return dbStatusContainer.get();
    }

    @Override
    public Status create(Status status) {
        statusRepository.save(status);
        return status;
    }

    @Override
    public Status update(Status newStatus) {
        Status dbStatus = findStatusById(newStatus.getId());
        dbStatus.setName(newStatus.getName());
        statusRepository.save(dbStatus);
        return dbStatus;
    }

    @Override
    public void delete(long statusId) {
        Status dbStatus = findStatusById(statusId);
        statusRepository.delete(dbStatus);

    }


}