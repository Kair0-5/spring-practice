package org.example.springpracticekairzhan.controller1;

import org.example.springpracticekairzhan.model1.User;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {
    private final Map<String, User> users = new HashMap<>();

    @PostMapping
    public User create(@RequestBody User user) {
        if (user.getMail() == null || user.getMail().isBlank()) {
            throw new RuntimeException("Почта пуста");
        }
        if (users.containsKey(user.getMail())) {
            throw new RuntimeException("Почта уже используется");
        }
        if (!user.getMail().contains("@")) {
            throw new RuntimeException("Почта должна содержать знак '@'");
        }
        if (user.getLogin() == null || user.getLogin().contains(" ")) {
            throw new RuntimeException("Логин не может быть пустым и содержать пробелы");
        }
        if (user.getBirthDate() == null) {
            throw new RuntimeException("Дата рождения не указана");
        }
        if (user.getBirthDate().isAfter(LocalDate.now())) {
            throw new RuntimeException("Дата рождения не может быть в будущем");
        }
        if (user.getName() == null || user.getName().isBlank()) {
            user.setName(user.getLogin());
            return user;
        }
        users.put(user.getMail(), user);
        return user;
    }

    @PutMapping
    public User update(@RequestBody User user) {
        if (user.getMail() == null || user.getMail().isBlank()) {
            throw new RuntimeException("Почта пуста");
        }
        if (!users.containsKey(user.getMail())) {
            throw new RuntimeException("Почта уже используется");
        }
        if (!user.getMail().contains("@")) {
            throw new RuntimeException("Почта должна содержать знак '@'");
        }
        users.put(user.getMail(), user);
        return user;
    }

    @GetMapping
    public List<User> userList() {
        return new ArrayList<>(users.values());
    }
}
