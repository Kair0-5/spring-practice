package org.example.springpracticekairzhan.controller;

import org.example.springpracticekairzhan.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {
    private final Map<String, User> users = new HashMap<>();
    @PostMapping
    public User create(@RequestBody User user)
    {
        if (user.getEmail() == null || user.getEmail().isBlank())
        {throw new RuntimeException("Почта пуста");}
        if (users.containsKey(user.getEmail()))
        {throw new RuntimeException("Почта уже используется");}
        users.put(user.getEmail(),user);
        return user;
    }
    @GetMapping
    public List<User> getAll(){return new ArrayList<>(users.values());}
    @PutMapping
    public User update(@RequestBody User user)
    {
        if (user.getEmail() == null || user.getEmail().isBlank())
        {throw new RuntimeException("Почта пуста");}
        users.put(user.getEmail(), user);
        return user;
    }
}
