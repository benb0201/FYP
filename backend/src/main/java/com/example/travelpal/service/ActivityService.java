package com.example.travelpal.service;

import com.example.travelpal.models.Activity;
import com.example.travelpal.repository.ActivityRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ActivityService {
    private ActivityRepository activityRepository;

    @Autowired
    public ActivityService(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    public List<Activity> getActivities() {
        return activityRepository.findAll();
    }

    public void addNewActivity(Activity activity) {
        activityRepository.save(activity);
    }

    public void deleteActivity(Long activityId) {
        boolean exists = activityRepository.existsById(activityId);
        if (!exists) {
            throw new EntityNotFoundException("Activity with ID " + activityId + " does not exist.");
        }
        activityRepository.deleteById(activityId);
    }

    @Transactional
    public void updateActivity(Activity activity, Long activityId) {
        Activity existingActivity = activityRepository.findById(activityId)
                .orElseThrow(() -> new EntityNotFoundException("Activity with ID " + activityId + " not found"));

        // Update the attributes of the existing activity with the values from the new activity
        existingActivity.setName(activity.getName());
        existingActivity.setDescription(activity.getDescription());
        existingActivity.setLocation(activity.getLocation());
        existingActivity.setCost(activity.getCost());

        // No need to explicitly save the object due to the @Transactional annotation
    //     The changes will be automatically persisted at the end of the transaction
        // Save the updated activity back to the repository
//        activityRepository.save(existingActivity);
    }
}