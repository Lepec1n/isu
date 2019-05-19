package com.isu.service;


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
    public Optional<Status> findStatusById(long id) {
        return statusRepository.findById(id);
    }

    @Override
    public void saveStatus(Status status) {
        statusRepository.save(status);
    }

    @Override
    public void updateStatus(Status status, Status newStatus) {
        status.setName(newStatus.getName());
        statusRepository.save(status);
    }

    @Override
    public void deleteStatusById(long statusId) {
        statusRepository.deleteById(statusId);
    }


}