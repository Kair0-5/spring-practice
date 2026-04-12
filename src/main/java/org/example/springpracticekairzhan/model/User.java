package org.example.springpracticekairzhan.model;

import java.time.LocalDate;

public class User {
    private String email;
    private String nickname;
    private LocalDate firstDate;

    public User() {}

    public User(String email, String nickname, LocalDate firstDate)
    {this.email = email;this.nickname = nickname;this.firstDate = firstDate;}

    public String getEmail() {return email;}
    public String getNickname() {return nickname;}
    public LocalDate getFirstDate() {return firstDate;}
    public void setEmail(String email) {this.email = email;}
    public void setNickname(String nickname) {this.nickname = nickname;}
    public void setFirstDate(LocalDate firstDate) {this.firstDate = firstDate;}
}
