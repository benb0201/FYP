package com.example.travelpal.dto;

import java.time.LocalDate;

public class RegisterDTO {

    private String name;
    private String email;
    private String password;
    private LocalDate dob;

    public RegisterDTO(String name, String email, String password, LocalDate dob){
        this.name = name;
        this.email = email;
        this.password = password;
        this.dob = dob;
    }

    public RegisterDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "RegisterDTO{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", dob=" + dob +
                '}';
    }
}
