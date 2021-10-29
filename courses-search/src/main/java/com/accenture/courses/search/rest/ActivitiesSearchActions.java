package com.accenture.courses.search.rest;

import com.accenture.courses.search.model.Activities;
import com.accenture.courses.search.service.ActivitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@CrossOrigin
@RequestMapping("/activities")
public class ActivitiesSearchActions {

    private final ActivitiesService activitiesService;

    @Autowired
    public ActivitiesSearchActions(ActivitiesService activitiesService) {

        this.activitiesService = activitiesService;
    }

    @CrossOrigin
    @GetMapping(path = "/")
    public ResponseEntity<List<Activities>> getAllActivities(){

        List<Activities> activities=activitiesService.getAllActivities();

        if (activities != null && !activities.isEmpty())
            return new ResponseEntity<>(activities, HttpStatus.OK);
        else
            return ResponseEntity.notFound().build();
    }
}
