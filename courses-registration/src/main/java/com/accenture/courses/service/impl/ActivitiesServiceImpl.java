package com.accenture.courses.service.impl;

import com.accenture.courses.registration.dto.ActivitiesDTO;
import com.accenture.courses.registration.model.Activities;
import com.accenture.courses.registration.repository.ActivitiesRepository;
import com.accenture.courses.service.ActivitiesService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivitiesServiceImpl implements ActivitiesService {
    private final ActivitiesRepository activitiesRepository;

    @Autowired
    public ActivitiesServiceImpl(ActivitiesRepository activitiesRepository) {
        this.activitiesRepository = activitiesRepository;
    }

    @Override
    public Activities saveActivities(Activities activities) {

        if(Strings.isBlank(activities.getTitle())) {
            throw new IllegalArgumentException("Activity title cannot be blank");
        }

        ActivitiesDTO dto=ActivitiesDTO.create(activities.getTitle(),activities.getStatus());

        ActivitiesDTO resp = activitiesRepository.save(dto);

        return Activities.create(resp.getTitle(), resp.getStatus());
    }
}
