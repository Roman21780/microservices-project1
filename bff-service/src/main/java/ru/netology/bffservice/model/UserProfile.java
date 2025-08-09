package ru.netology.bffservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.common.model.Order;
import ru.netology.common.model.User;


import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserProfile {
    private User user;
    private List<Order> orders;
}
