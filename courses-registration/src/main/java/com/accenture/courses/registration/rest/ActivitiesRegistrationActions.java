package com.accenture.courses.registration.rest;

import com.accenture.courses.registration.model.Activities;
import com.accenture.courses.registration.model.Course;
import com.accenture.courses.service.ActivitiesService;
import com.accenture.courses.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController()
@CrossOrigin
@RequestMapping("/activities")
public class ActivitiesRegistrationActions {
    private final ActivitiesService activitiesService;

    @Autowired
    public ActivitiesRegistrationActions(final ActivitiesService activitiesService){
        this.activitiesService = activitiesService;
    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity<Activities> registerActivities(@RequestBody Activities activities, UriComponentsBuilder uriBui) {
        Activities resp=activitiesService.saveActivities(activities);

        URI newCourseUri=uriBui.path("/{title}").build(resp.getTitle());

        return ResponseEntity.created(newCourseUri).body(resp);
    }


}
