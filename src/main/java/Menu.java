import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<MenuItem> items;

    public Menu() {
        items = new ArrayList<>();
    }

    public void addMenuItem(MenuItem item) {
        items.add(item);
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public void displayMenu() {
        for (MenuItem item : items) {
            System.out.println(item);
        }
    }
}