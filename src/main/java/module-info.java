module com.example.scrollpanewiki {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.scrollpanewiki to javafx.fxml;
    exports com.example.scrollpanewiki;
}