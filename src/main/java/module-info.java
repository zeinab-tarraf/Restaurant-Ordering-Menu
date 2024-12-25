module com.example.restaurantorderingsystem {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.restaurantorderingsystem to javafx.fxml;
    exports com.example.restaurantorderingsystem;
}