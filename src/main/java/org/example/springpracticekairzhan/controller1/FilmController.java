package org.example.springpracticekairzhan.controller1;

import org.example.springpracticekairzhan.model1.Film;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
public class FilmController {
    private final List<Film> films = new ArrayList<>();

    @PostMapping("/films")
    public Film create(@RequestBody Film film) {
        if (film.getName() == null || film.getName().isBlank()) {
            throw new RuntimeException("Название не может быть пустым");
        }
        if (film.getName().length() > 201) {
            throw new RuntimeException("Название не может быть больше 200 символов");
        }
        LocalDate minDate = LocalDate.of(1895, 12, 28);
        if (film.getReleaseDate().isBefore(minDate)) {
            throw new RuntimeException("Дата релиза не может быть ранее 28.12.1895");
        }
        if (film.getMinute() < 0) {
            throw new RuntimeException("Продолжительность должен быть положительным");
        }
        films.add(film);
        return film;
    }

    @PutMapping
    public Film update(@RequestBody Film film) {
        for (int i = 0; i < films.size(); i++) {
            if (films.get(i).getId() == film.getId()) {
                films.set(i, film);
                return film;
            }
        }
        return film;
    }

    @GetMapping("/films")
    public List<Film> getFilms() {
        return films;
    }
}
