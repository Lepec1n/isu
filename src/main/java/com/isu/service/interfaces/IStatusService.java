package com.isu.service.interfaces;

import com.isu.model.Status;

import java.util.List;

public interface IStatusService {
    List<Status> getStatuses();
    Status create(Status status);
    Status update(Status newStatus);
    Status findStatusById(long id);
    void delete(long statusId);
}
