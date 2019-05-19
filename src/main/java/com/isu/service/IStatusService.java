package com.isu.service;

import com.isu.model.Status;

import java.util.List;
import java.util.Optional;

public interface IStatusService {
    List<Status> getStatuses();
    void saveStatus(Status status);
    void updateStatus(Status status, Status newStatus);
    Optional<Status> findStatusById(long id);
    void deleteStatusById(long statusId);
}
