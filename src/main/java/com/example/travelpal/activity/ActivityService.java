package com.example.travelpal.activity;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActivityService {
    private ActivityRepository activityRepository;

    @Autowired
    public ActivityService(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    public List<Activity> getActivities(){
        return activityRepository.findAll();
    }

    public void addNewActivity(Activity activity){
        activityRepository.save(activity);
    }

    public void deleteActivity(Long activityId){
        activityRepository.deleteById(activityId);
    }

    public void updateActivity(Activity activity, Long activityId){
        Optional<Activity> activityOptional = activityRepository.findById(activityId);
        if (activityOptional.isEmpty()) {
            throw new EntityNotFoundException("Itinerary with ID " + activityId + " not found");
        }

        // Get the existing activity from the Optional
        Activity existingActivity = activityOptional.get();

        // Update the attributes of the existing activity with the values from the new activity
        existingActivity.setName(activity.getName());
        existingActivity.setDescription(activity.getDescription());
        existingActivity.setLocation(activity.getLocation());
        existingActivity.setType(activity.getType());
        existingActivity.setCost(activity.getCost());
        existingActivity.setDestinations(activity.getDestinations());

        // Save the updated activity back to the repository
        activityRepository.save(existingActivity);
    }
}
