package com.example.demo.model;

public class Users {
    private Long id;
    private String fullName;
    private String email;
    private String password;
    private String role;

public Users(){

}
public Users(Long id, String fullName, String email, String password, String role) {
    this.id = id;
    this.fullName = fullName;
    this.email = email;
    this.password = password;
    this.role = role;
}
public String getFullName() {
    return fullName;
}
public String getEmail() {
    return email;
}
public String getPassword() {
    return password;
}
public String getRole() {
    return role;
}
public void setFullName(String fullName) {
    this.fullName = fullName;
}
public void setEmail(String email) {
    this.email = email;
}
public void setPassword(String password) {
    this.password = password;
}
public void setRole(String role) {
    this.role = role;
}
}

