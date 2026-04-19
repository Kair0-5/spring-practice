package org.example.springpracticekairzhan.model1;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter

public class User {
    private int id;
    private String mail;
    private String login;
    private String name;
    private LocalDate birthDate;
}
