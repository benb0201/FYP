package com.example.travelpal.response;

public class RegisterResponse {
    String message;
    Boolean status;
    Long id;

    public RegisterResponse(String message, Boolean status, Long id) {
        this.message = message;
        this.status = status;
        this.id = id;
    }

    public RegisterResponse(String message, Boolean status) {
        this.message = message;
        this.status = status;
    }

    public RegisterResponse() {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "RegisterResponse{" +
                "message='" + message + '\'' +
                ", status=" + status +
                ", id=" + id +
                '}';
    }
}
