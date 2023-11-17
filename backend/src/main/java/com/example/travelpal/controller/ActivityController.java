package com.example.travelpal.controller;

import com.example.travelpal.service.ActivityService;
import com.example.travelpal.models.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/activity")
public class ActivityController {
    private ActivityService activityService;

    @Autowired
    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @GetMapping
    public List<Activity> getActivities(){
        return activityService.getActivities();
    }

    @PostMapping
    public void registerActivity(@RequestBody Activity activity){
        activityService.addNewActivity(activity);
    }

    @DeleteMapping (path = "{activityid}")
    public void deleteActivity(@PathVariable Long activityId){
        activityService.deleteActivity(activityId);
    }

    @PutMapping (path = "{activityid}")
    public void updateActivity(@RequestBody Activity activity, @PathVariable Long activityId){
        activityService.updateActivity(activity, activityId);
    }
}
