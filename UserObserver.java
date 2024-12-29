package com.example.restaurantorderingsystem;

public class UserObserver implements OrderObserver {
    private User user;

    public UserObserver(User user) {
        this.user = user;
    }

    @Override
    public void update(String message) {
        System.out.println("User " + user.getUsername() + " received update: " + message);
    }
}
