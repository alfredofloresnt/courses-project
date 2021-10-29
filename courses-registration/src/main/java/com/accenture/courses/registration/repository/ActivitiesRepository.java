package com.accenture.courses.registration.repository;

import com.accenture.courses.registration.dto.ActivitiesDTO;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ActivitiesRepository extends MongoRepository<ActivitiesDTO, String> {

}
