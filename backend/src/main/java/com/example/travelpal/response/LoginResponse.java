package com.example.travelpal.response;

public class LoginResponse {
    String message;
    Boolean status;
    Long id;

    public LoginResponse(String message, Boolean status, Long id) {
        this.message = message;
        this.status = status;
        this.id = id;
    }

    public LoginResponse(String message, Boolean status) {
        this.message = message;
        this.status = status;
    }

    public LoginResponse() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "message='" + message + '\'' +
                ", status=" + status +
                ", id=" + id +
                '}';
    }
}
