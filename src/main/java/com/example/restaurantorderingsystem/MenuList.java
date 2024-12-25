package com.example.restaurantorderingsystem;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MenuList {
    private ObservableList<MenuItem> items;

    public MenuList() {
        items = FXCollections.observableArrayList();  // Using ObservableList for compatibility with ListView
    }

    public void addMenuItem(MenuItem menuItem) {
        items.add(menuItem);
    }

    public ObservableList<MenuItem> getItems() {
        return items;
    }
}
