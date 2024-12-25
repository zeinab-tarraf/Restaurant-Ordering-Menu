import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<MenuItem> items;
    private List<OrderObserver> observers;

    public Order() {
        items = new ArrayList<>();
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

    public void placeOrder(List<MenuItem> menuItems) {
        items.addAll(menuItems);
        double total = calculateTotal();
        notifyObservers("Your order has been placed. Total amount: $" + total);
    }

    public double calculateTotal() {
        double total = 0;
        for (MenuItem item : items) {
            total += item.getPrice();
        }
        return total;
    }
}