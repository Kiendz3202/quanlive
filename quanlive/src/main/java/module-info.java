module com.example.quanlive {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.quanlive to javafx.fxml;
    exports com.example.quanlive;
}