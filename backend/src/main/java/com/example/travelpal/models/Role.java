//package com.example.travelpal.models;
//
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.Setter;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.GrantedAuthority;
//
//@Getter
//@Setter
//@Entity
//@Table(name ="roles")
//public class Role implements GrantedAuthority {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "role_id")
//    private Long id;
//
//    private String authority;
//
//    public Role() {
//        super();
//    }
//
//    public Role(String authority) {
//        this.authority = authority;
//    }
//
//    public Role(Long id, String authority) {
//        this.id = id;
//        this.authority = authority;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    @Override
//    public String getAuthority() {
//        return this.authority;
//    }
//
//    public void setAuthority(String authority) {
//        this.authority = authority;
//    }
//}
