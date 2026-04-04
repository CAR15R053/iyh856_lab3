module edu.utsa.cs3443.iyh856_lab3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens edu.utsa.cs3443.iyh856_lab3 to javafx.fxml;
    exports edu.utsa.cs3443.iyh856_lab3;
    exports edu.utsa.cs3443.iyh856_lab3.model;
    opens edu.utsa.cs3443.iyh856_lab3.model to javafx.fxml;
}