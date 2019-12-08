package com.isu.service;

import com.isu.exception.RingNotFoundException;
import com.isu.model.Ring;
import com.isu.repository.RingRepository;
import com.isu.service.interfaces.IRingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RingServiceImpl implements IRingService {

    @Autowired
    RingRepository ringRepository;

    @Override
    public List<Ring> findAll() {
        return ringRepository.findAll();
    }

    @Override
    public Ring findById(Long ring_id) {
        Optional<Ring> dbRingContainer = ringRepository.findById(ring_id);
        if(!dbRingContainer.isPresent())
            throw new RingNotFoundException(ring_id);
        return dbRingContainer.get();

    }

    @Override
    public Ring create(Ring ring) {
        ringRepository.save(ring);
        return ring;
    }

    @Override
    public Ring update(Ring ring) {
        Ring dbRing = findById(ring.getId());
        dbRing.setUser(ring.getUser());
        ringRepository.save(dbRing);
        return dbRing;
    }

    @Override
    public void delete(Long ring_id) {
        Ring dbRing = findById(ring_id);
        delete(dbRing);
    }

    @Override
    public void delete(Ring ring) {
        ringRepository.delete(ring);
    }
}
