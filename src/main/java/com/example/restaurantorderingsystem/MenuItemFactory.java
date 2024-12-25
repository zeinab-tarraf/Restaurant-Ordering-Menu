package com.example.restaurantorderingsystem;

public class MenuItemFactory {
    public MenuItem createMenuItem(String name, String description, double price) {
        return new MenuItem(name, description, price);
    }
}
