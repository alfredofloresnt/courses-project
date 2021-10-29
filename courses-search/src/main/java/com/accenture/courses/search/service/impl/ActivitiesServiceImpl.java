package com.accenture.courses.search.service.impl;

import com.accenture.courses.search.dto.ActivitiesDTO;
import com.accenture.courses.search.dto.CourseDTO;
import com.accenture.courses.search.model.Activities;
import com.accenture.courses.search.model.Course;
import com.accenture.courses.search.repository.ActivitiesRepository;
import com.accenture.courses.search.repository.CourseRepository;
import com.accenture.courses.search.service.ActivitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ActivitiesServiceImpl implements ActivitiesService {

    private final ActivitiesRepository activitiesRepository;

    @Autowired
    public ActivitiesServiceImpl(ActivitiesRepository activitiesRepository) {
        this.activitiesRepository = activitiesRepository;
    }

    @Override
    public List<Activities> getAllActivities() {
        List<ActivitiesDTO> activitiesList = activitiesRepository.findAll();

        List<Activities> activities = new ArrayList<>();

        for (ActivitiesDTO dto : activitiesList) {
            activities.add(convertToModel(dto));
        }
        return activities;
    }

    private Activities convertToModel(ActivitiesDTO activitiesDTO) {

        Activities activities = Activities.create(activitiesDTO.getTitle(), activitiesDTO.getStatus());

        return activities;
    }

}
