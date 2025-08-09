package ru.netology.bffservice.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.netology.bffservice.model.UserProfile;
import ru.netology.common.model.Order;
import ru.netology.common.model.User;

import java.util.List;

@Service
public class UserProfileService {

    private final RestTemplate restTemplate;

    @Value("${user.service.url}")
    private String userServiceUrl;

    @Value("${order.service.url}")
    private String orderServiceUrl;

    public UserProfileService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public UserProfile getUserProfile(Long userId) {
        User user = restTemplate.getForObject(
                userServiceUrl + "/api/users/" + userId, User.class);

        List<Order> orders = restTemplate.exchange(
                orderServiceUrl + "/api/orders/by-user/" + userId,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Order>>() {}).getBody();

        return new UserProfile(user, orders != null ? orders : List.of());
    }
}
