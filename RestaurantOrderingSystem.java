package com.example.restaurantorderingsystem;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RestaurantOrderingSystem extends Application {
    private MenuList menuList;  // Use MenuList instead of Menu
    private Order order;

    @Override
    public void start(Stage primaryStage) {
        menuList = new MenuList();  // Initialize MenuList
        MenuItemFactory factory = new MenuItemFactory();

        // Adding menu items
        menuList.addMenuItem(factory.createMenuItem("Burger", "Delicious beef burger", 5.99));
        menuList.addMenuItem(factory.createMenuItem("Pizza", "Cheesy pizza with toppings", 8.99));
        menuList.addMenuItem(factory.createMenuItem("Salad", "Fresh garden salad", 4.99));
        menuList.addMenuItem(factory.createMenuItem("Kinza", "because Pepsi is Boycotted", 0.99));


        order = new Order();
        User user = new User("JohnDoe", "password123");
        UserObserver userObserver = new UserObserver(user);
        order.attach(userObserver);

        // GUI Components
        ListView<MenuItem> menuListView = new ListView<>();
        menuListView.getItems().addAll(menuList.getItems());  // Use getItems from MenuList

        TextArea orderDetails = new TextArea();
        orderDetails.setEditable(false);

        Button orderButton = new Button("Place Order");
        orderButton.setOnAction(e -> {
            order.placeOrder(menuListView.getSelectionModel().getSelectedItems());
            orderDetails.setText("Order placed successfully!\n" + order.getOrderDetails());
        });

        VBox root = new VBox(10, menuListView, orderButton, orderDetails);
        Scene scene = new Scene(root, 400, 300);
        primaryStage.setTitle("Restaurant Ordering System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
