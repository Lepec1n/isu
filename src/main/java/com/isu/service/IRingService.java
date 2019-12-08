package com.isu.service;

import com.isu.model.Ring;

import java.util.List;

public interface IRingService {

    List<Ring> findAll();

    Ring findById(Long ring_id);

    Ring create(Ring ring);

    Ring update(Ring ring);

    void delete(Long ring_id);

    void delete(Ring ring);
}
