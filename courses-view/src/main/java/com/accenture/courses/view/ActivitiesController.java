package com.accenture.courses.view;

import com.accenture.courses.view.model.Activities;
import com.accenture.courses.view.model.Course;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Controller
public class ActivitiesController {
    private static String GET_URL="http://courses-search:9090/activities/";

    private static String POST_URL="http://courses-registration:8080/activities/";

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @CrossOrigin
    @GetMapping("/")
    public String index(Model model) {

        List<Activities> activitesList= Arrays.asList(
                restTemplate.getForObject(GET_URL, Activities[].class));

        ArrayList<Activities> activities=new ArrayList<>(activitesList);
        final Gson gson = new Gson();
        final String representacionJSON = gson.toJson(activities);
        model.addAttribute("activities", representacionJSON);

        // return view name
        return "index";
    }
    @CrossOrigin
    @GetMapping("/register")
    public String registerForm(Model model){
        Activities activities=new Activities();

        model.addAttribute("activities",activities);

        return "register_form";
    }
    @CrossOrigin
    @PostMapping("/register")
    public String submitRegister(@ModelAttribute("activities") Activities activities) {

        HttpHeaders headers=new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        HttpEntity<Activities> entityActivities=new HttpEntity<>(activities,headers);

        ResponseEntity<Activities> resp=restTemplate.postForEntity(POST_URL,entityActivities,Activities.class);

        return "redirect:/";
    }
}
