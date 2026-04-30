module edu.utsa.cs3443.iyh856_lab4 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens edu.utsa.cs3443.iyh856_lab4 to javafx.fxml;
    exports edu.utsa.cs3443.iyh856_lab4;
    exports edu.utsa.cs3443.iyh856_lab4.model;
    opens edu.utsa.cs3443.iyh856_lab4.model to javafx.fxml;
}