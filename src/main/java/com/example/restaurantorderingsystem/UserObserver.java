package com.example.restaurantorderingsystem;

public class UserObserver implements OrderObserver {
    private User user;

    public UserObserver(User user) {
        this.user = user;
    }

    @Override
    public void update(String message) {
        // Here you can implement how the user will receive updates.
        // For example, you could print to the console or update a UI component.
        System.out.println("User  " + user.getUsername() + " received update: " + message);
    }
}