package com.example.travelpal.user;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class UserService {

    public List<User> getUsers(){
        return List.of(
                new User(
                        1L,
                        "user1",
                        "user1@hmail.com",
                        LocalDate.of(2000, Month.JANUARY, 5),
                        21
                )
        );
    }
}
