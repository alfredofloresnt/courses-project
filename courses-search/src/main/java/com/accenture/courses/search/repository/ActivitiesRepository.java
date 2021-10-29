package com.accenture.courses.search.repository;

import com.accenture.courses.search.dto.ActivitiesDTO;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ActivitiesRepository extends MongoRepository<ActivitiesDTO, String> {
    @Override
    List<ActivitiesDTO> findAll();

    @Override
    Optional<ActivitiesDTO> findById(String s);
}
