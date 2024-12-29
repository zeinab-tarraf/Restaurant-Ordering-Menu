package com.example.restaurantorderingsystem;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class RestaurantOrderingSystem extends Application {
    private MenuList menuList;
    private Order order = new Order();

    @Override
    public void start(Stage primaryStage) {
        menuList = new MenuList();  // Initialize MenuList
        MenuItemFactory factory = new MenuItemFactory();
        User user = new User("User 123"); // Create a user instance
        UserObserver userObserver = new UserObserver(user); // Create a UserObserver instance
        order.attach(userObserver); // Attach the observer to the order

        // Add menu items
        menuList.addMenuItem(factory.createMenuItem("Mint Shisha", "Refreshing mint flavor", 10.00));
        menuList.addMenuItem(factory.createMenuItem("Fruit Shisha", "Mixed fruit flavors", 12.00));
        menuList.addMenuItem(factory.createMenuItem("Grape Shisha", "Sweet grape flavor", 11.00));
        menuList.addMenuItem(factory.createMenuItem("Teffehten Shisha", "Classic teffehten flavor", 10.50));
        menuList.addMenuItem(factory.createMenuItem("Pancakes", "Fluffy pancakes with syrup", 6.99));
        menuList.addMenuItem(factory.createMenuItem("Omelette", "Classic omelette with cheese", 5.99));
        menuList.addMenuItem(factory.createMenuItem("Fruit Salad", "Fresh seasonal fruits", 4.99));
        menuList.addMenuItem(factory.createMenuItem("French Toast", "Toasted bread with cinnamon and syrup", 7.49));
        menuList.addMenuItem(factory.createMenuItem("Breakfast Burrito", "Scrambled eggs, cheese, and salsa wrapped in a tortilla", 8.99));
        menuList.addMenuItem(factory.createMenuItem("Spring Rolls", "Crispy rolls filled with vegetables", 5.49));
        menuList.addMenuItem(factory.createMenuItem("Garlic Bread", "Toasted bread with garlic and herbs", 3.99));
        menuList.addMenuItem(factory.createMenuItem("Bruschetta", "Toasted bread topped with tomatoes and basil", 6.49));
        menuList.addMenuItem(factory.createMenuItem("Chicken Wings", "Spicy chicken wings served with dipping sauce", 8.99));
        menuList.addMenuItem(factory.createMenuItem("Coke", "Refreshing cola drink", 1.99));
        menuList.addMenuItem(factory.createMenuItem("Orange Juice", "Freshly squeezed orange juice", 2.99));
        menuList.addMenuItem(factory.createMenuItem("Lemonade", "Freshly made lemonade", 2.49));
        menuList.addMenuItem(factory.createMenuItem("Iced Tea", "Chilled tea with lemon", 2.29));
        menuList.addMenuItem(factory.createMenuItem("Burger", "Delicious beef burger", 5.99));
        menuList.addMenuItem(factory.createMenuItem("Pizza", "Cheesy pizza with toppings", 8.99));
        menuList.addMenuItem(factory.createMenuItem("Salad", "Fresh garden salad", 4.99));
        menuList.addMenuItem(factory.createMenuItem("Club Sandwich", "Triple-decker sandwich with turkey and bacon", 7.99));
        menuList.addMenuItem(factory.createMenuItem("Ice Cream", "Delicious vanilla ice cream", 3.99));
        menuList.addMenuItem(factory.createMenuItem("Cheesecake", "Creamy cheesecake", 4.99));
        menuList.addMenuItem(factory.createMenuItem("Brownie", "Rich chocolate brownie", 2.99));
        menuList.addMenuItem(factory.createMenuItem("Fruit Tart", "Tart filled with fresh fruits and cream", 5.49));
        menuList.addMenuItem(factory.createMenuItem("Grilled Chicken", "Juicy grilled chicken breast", 12.99));
        menuList.addMenuItem(factory.createMenuItem("Steak", "Tender steak cooked to perfection", 19.99));
        menuList.addMenuItem(factory.createMenuItem("Vegetable Stir Fry", "Mixed vegetables stir-fried in sauce", 10.99));
        menuList.addMenuItem(factory.createMenuItem("Pasta Primavera", "Pasta with fresh vegetables and sauce", 11.49));



        TreeItem<String> shishaItem = new TreeItem<>("Shisha");
        shishaItem.getChildren().addAll(
                new TreeItem<>("Mint Shisha - Refreshing mint flavor - $10.00"),
                new TreeItem<>("Fruit Shisha - Mixed fruit flavors - $12.00"),
                new TreeItem<>("Grape Shisha - Sweet grape flavor - $11.00"),
                new TreeItem<>("Double Apple Shisha - Classic double apple flavor - $10.50")
        );

        TreeItem<String> breakfastItem = new TreeItem<>("Breakfast");
        breakfastItem.getChildren().addAll(
                new TreeItem<>("Pancakes - Fluffy pancakes with syrup - $6.99"),
                new TreeItem<>("Omelette - Classic omelette with cheese - $5.99"),
                new TreeItem<>("Fruit Salad - Fresh seasonal fruits - $4.99"),
                new TreeItem<>("French Toast - Toasted bread with cinnamon and syrup - $7.49"),
                new TreeItem<>("Breakfast Burrito - Scrambled eggs, cheese, and salsa wrapped in a tortilla - $8.99")
        );

        // New Appetizers section
        TreeItem<String> appetizersItem = new TreeItem<>("Appetizers");
        appetizersItem.getChildren().addAll(
                new TreeItem<>("Spring Rolls - Crispy rolls filled with vegetables - $5.49"),
                new TreeItem<>("Garlic Bread - Toasted bread with garlic and herbs - $3.99"),
                new TreeItem<>("Bruschetta - Toasted bread topped with tomatoes and basil - $6.49"),
                new TreeItem<>("Chicken Wings - Spicy chicken wings served with dipping sauce - $8.99")
        );


        // Create root item and add categories
        TreeItem<String> rootItem = new TreeItem<>("Open Menu");
        TreeItem<String> drinksItem = new TreeItem<>("Drinks");
        TreeItem<String> lunchItem = new TreeItem<>("Lunch");
        TreeItem<String> dessertsItem = new TreeItem<>("Desserts");
        TreeItem<String> ShishaItems = new TreeItem<>("Shisha");
        TreeItem<String> breakfastItems = new TreeItem<>("Breakfast");
        TreeItem<String> appetizersItems = new TreeItem<>("Appetizers");
        // Add menu items to their respective categories
        drinksItem.getChildren().addAll(
                new TreeItem<>("Coke - Refreshing cola drink - $1.99"),
                new TreeItem<>("Orange Juice - Freshly squeezed orange juice - $2.99"),
                new TreeItem<>("Lemonade - Freshly made lemonade - $2.49"),
                new TreeItem<>("Iced Tea - Chilled tea with lemon - $2.29")
        );

        lunchItem.getChildren().addAll(
                new TreeItem<>("Burger - Delicious beef burger - $5.99"),
                new TreeItem<>("Pizza - Cheesy pizza with toppings - $8.99"),
                new TreeItem<>("Salad - Fresh garden salad - $4.99"),
                new TreeItem<>("Club Sandwich - Triple-decker sandwich with turkey and bacon - $7.99")
        );

        dessertsItem.getChildren().addAll(
                new TreeItem<>("Ice Cream - Delicious vanilla ice cream - $3.99"),
                new TreeItem<>("Cheesecake - Creamy cheesecake - $4.99"),
                new TreeItem<>("Brownie - Rich chocolate brownie - $2.99"),
                new TreeItem<>("Fruit Tart - Tart filled with fresh fruits and cream - $5.49")
        );

        // Add categories to the root item
        rootItem.getChildren().addAll(drinksItem, lunchItem, dessertsItem, shishaItem, breakfastItem, appetizersItem);


        TreeView<String> menuTreeView = new TreeView<>(rootItem);
        menuTreeView.setShowRoot(true); // Show the root item

        TextArea orderDetails = new TextArea();
        orderDetails.setEditable(false);

        Button orderButton = new Button("Place Order");
        orderButton.setOnAction(e -> {
            // Get selected item from TreeView
            TreeItem<String> selectedItem = menuTreeView.getSelectionModel().getSelectedItem();
            if (selectedItem != null) {
                String itemDetails = selectedItem.getValue();
                String[] parts = itemDetails.split(" - ");
                if (parts.length > 0) {
                    String itemName = parts[0];
                    MenuItem selectedMenuItem = findMenuItemByName(itemName);
                    if (selectedMenuItem != null) {
                        order.placeOrder(List.of(selectedMenuItem)); // Place the order
                        orderDetails.setText("Order placed successfully!\n" + order.getOrderDetails());
                    } else {
                        orderDetails.setText("Menu item not found!");
                    }
                } else {
                    orderDetails.setText("Invalid item format!");
                }
            } else {
                orderDetails.setText("Please select a menu item to order!");
            }
        });

        Button exitButton = new Button("Exit");
        exitButton.setOnAction(e -> {
            primaryStage.close();
        });

        // Create a VBox layout
        VBox root = new VBox(10, menuTreeView, orderButton, exitButton, orderDetails);
        root.setStyle("-fx-background-color: lightblue;");

        Scene scene = new Scene(root, 800, 600); // Set the desired width and height
        primaryStage.setTitle("Restaurant Ordering System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private MenuItem findMenuItemByName(String name) {
        for (MenuItem item : menuList.getItems()) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null; // Return null if not found
    }

    public static void main(String[] args) {
        launch(args);
    }
}