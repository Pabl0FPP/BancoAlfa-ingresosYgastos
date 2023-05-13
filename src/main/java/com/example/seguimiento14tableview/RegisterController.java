package com.example.seguimiento14tableview;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;


public class RegisterController implements Initializable {


    @FXML
    private TextField descMontoTF;

    @FXML
    private Button enviarBtn;

    @FXML
    private DatePicker fechaMontoDP;

    @FXML
    private TextField montoTF;

    @FXML
    private Button regresarBtn;

    @FXML
    private ComboBox<String> tipoMontoCB;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ObservableList<String> list = FXCollections.observableArrayList("Ingresos", "Gastos");
        tipoMontoCB.setItems(list);

        //ESTO NO SE COMO FUNCIONA
        tipoMontoCB.getSelectionModel().selectedItemProperty().addListener((value, old, nu) -> {
            montoTF.setText("");
            descMontoTF.setText("");
        });


        regresarBtn.setOnAction(action -> {
            HelloApplication.openWindows("hello-view.fxml");
            Stage stage = (Stage) regresarBtn.getScene().getWindow();
            stage.close();
        });

        enviarBtn.setOnAction(action -> {

            try {
                double monto = Double.parseDouble(montoTF.getText());
                String descripcion = descMontoTF.getText();
                String montoType = "";
                if (tipoMontoCB.getSelectionModel().isSelected(0)) montoType = "Ingresos";
                else if (tipoMontoCB.getSelectionModel().isSelected(1)) {
                    montoType = "Gastos";
                    monto = (-1) * monto;
                }
                Monto newMonto = new Monto(montoType, descripcion, fechaMontoDP.getValue(), monto);
                MontoList.getInstance().getMontos().add(newMonto);
                if (MontoList.getInstance().getMontos().contains(newMonto)) {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setContentText(" El "+newMonto.getMontoType()+" por $"+newMonto.getMonto() + " fue registrado exitosamente");
                    alert.show();
                }
            }catch (Exception e){
                e.printStackTrace();
            }


            montoTF.setText("");
            descMontoTF.setText("");
            fechaMontoDP.setAccessibleText("");
        });


    }


}

