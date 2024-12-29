package com.example.restaurantorderingsystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Order {
    private Map<MenuItem, Integer> items; // Changed to a Map to track quantities
    private List<OrderObserver> observers;

    public Order() {
        items = new HashMap<>();
        observers = new ArrayList<>();
    }

    public void attach(OrderObserver observer) {
        observers.add(observer);
    }

    public void detach(OrderObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String message) {
        for (OrderObserver observer : observers) {
            observer.update(message);
        }
    }

    public void placeOrder(List<MenuItem> selectedItems) {
        for (MenuItem item : selectedItems) {
            items.put(item, items.getOrDefault(item, 0) + 1); // Increment the quantity
        }
        double total = calculateTotal();
        notifyObservers("Your order has been placed. Total amount: $" + total);
    }

    public double calculateTotal() {
        double total = 0;
        for (Map.Entry<MenuItem, Integer> entry : items.entrySet()) {
            total += entry.getKey().getPrice() * entry.getValue(); // Calculate total based on quantity
        }
        return total;
    }

    public String getOrderDetails() {
        StringBuilder details = new StringBuilder();
        for (Map.Entry<MenuItem, Integer> entry : items.entrySet()) {
            details.append(entry.getKey().toString());
            if (entry.getValue() > 1) {
                details.append(" x").append(entry.getValue()); // Append quantity if more than 1
            }
            details.append("\n");
        }
        details.append("Total: $").append(calculateTotal());
        return details.toString();
    }
}