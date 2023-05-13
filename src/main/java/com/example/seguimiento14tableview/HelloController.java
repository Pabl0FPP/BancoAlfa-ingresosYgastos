package com.example.seguimiento14tableview;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private Button RegisterBtn;

    @FXML
    private Button viewBtn;


    @FXML
    private Label balanceLbl;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        double valor = 0;
        for (Monto monto : MontoList.getInstance().getMontos()) {
            valor += monto.getMonto();
        }
        balanceLbl.setText(String.valueOf(valor));

        RegisterBtn.setOnAction(action->{
            HelloApplication.openWindows("register.fxml");
            Stage stage= (Stage) RegisterBtn.getScene().getWindow();
            stage.close();
        });

        viewBtn.setOnAction(action ->{
         HelloApplication.openWindows("view.fxml");
            Stage stage= (Stage) viewBtn.getScene().getWindow();
            stage.close();
        });

    }
}
