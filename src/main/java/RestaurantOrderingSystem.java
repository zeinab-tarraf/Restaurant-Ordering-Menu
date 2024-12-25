import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RestaurantOrderingSystem extends Application {
    @Override
    public void start(Stage primaryStage) {
        Menu menu = new Menu();
        MenuItemFactory factory = new MenuItemFactory();

        menu.addMenuItem(factory.createMenuItem("Burger", "Delicious beef burger", 5.99));
        menu.addMenuItem(factory.createMenuItem("Pizza", "Cheesy pizza with toppings", 8.99));

        Order order = new Order();
        User user = new User("JohnDoe", "password123");
        UserObserver userObserver = new UserObserver(user);
        order.attach(userObserver);

        // Simulate placing an order
        order.placeOrder(menu.getItems());

        VBox root = new VBox();
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("Restaurant Ordering System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}