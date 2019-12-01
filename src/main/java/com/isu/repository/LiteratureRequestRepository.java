package com.isu.repository;

import com.isu.model.LiteratureRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LiteratureRequestRepository extends JpaRepository<LiteratureRequest, Long>{

    List<LiteratureRequest> findAll();
}
