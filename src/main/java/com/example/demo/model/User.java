// package com.example.demo.model;

// public class User {

//     private Long userId;
//     private String username;
//     private String role;

//     public User() {}

//     public Long getUserId() {
//         return userId;
//     }

//     public String getUsername() {
//         return username;
//     }

//     public String getRole() {
//         return role;
//     }

//     public void setUserId(Long userId) {
//         this.userId = userId;
//     }

//     public void setUsername(String username) {
//         this.username = username;
//     }

//     public void setRole(String role) {
//         this.role = role;
//     }
// }


package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users") // 'user' is often a reserved word in SQL, so 'users' is safer
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    
    private String username;
    private String role;

    public User() {}

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}