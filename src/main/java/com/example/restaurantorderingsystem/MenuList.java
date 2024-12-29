package com.example.restaurantorderingsystem;

import java.util.ArrayList;
import java.util.List;

public class MenuList {
    private List<MenuItem> items;

    public MenuList() {
        items = new ArrayList<>();
    }

    public void addMenuItem(MenuItem item) {
        items.add(item);
    }

    public MenuItem[] getItems() {
        return items.toArray(new MenuItem[0]);
    }
}