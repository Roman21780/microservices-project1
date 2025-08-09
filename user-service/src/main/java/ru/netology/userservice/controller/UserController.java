package ru.netology.userservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.common.model.User;


import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final Map<Long, User> users = new HashMap<>();

    public UserController() {
        // Инициализация тестовых данных
        users.put(1L, new User(1L, "Иванов Иван Иванович",
                "ул. Пушкина, д.10", "+79991234567", "ivanov@example.com"));
        users.put(2L, new User(2L, "Петров Петр Петрович",
                "ул. Лермонтова, д.5", "+79998765432", "petrov@example.com"));
    }

    @GetMapping("/{userId}")
    public User getUser(@PathVariable Long userId) {
        return users.get(userId);
    }
}
