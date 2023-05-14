package com.example.seguimiento14tableview;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Predicate;


public class ViewController implements Initializable {


    FilteredList<Monto> montos=new FilteredList<>(MontoList.getInstance().montos);

    @FXML
    private TableColumn<?, ?> descripcionTC;

    @FXML
    private TableColumn<?, ?> fechaTC;

    @FXML
    private TableView<Monto> tablaMontoTV;

    @FXML
    private TableColumn<?, ?> tipoMontoTC;

    @FXML
    private TableColumn<?, ?> valorTC;

    @FXML
    private Button verGastosBtn;

    @FXML
    private Button verIngresosBtn;

    @FXML
    private Button verTodoBtn;

    @FXML
    private Button regresarBtn;

    @FXML
    private Button eliminarMontoBtn;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        valorTC.setCellValueFactory(new PropertyValueFactory<>("monto"));
        descripcionTC.setCellValueFactory(new PropertyValueFactory<>("descMonto"));
        tipoMontoTC.setCellValueFactory(new PropertyValueFactory<>("MontoType"));
        fechaTC.setCellValueFactory(new PropertyValueFactory<>("dateMonto"));

        regresarBtn.setOnAction(action->{
            HelloApplication.openWindows("hello-view.fxml");
            Stage stage= (Stage) regresarBtn.getScene().getWindow();
            stage.close();
        });

        verIngresosBtn.setOnAction(action -> {
            Predicate<Monto> filtered= monto -> monto.getMontoType().equals("Ingresos");
            tablaMontoTV.setItems(
                    MontoList.getInstance().getMontos().filtered(filtered)
            );

        });

        verGastosBtn.setOnAction(action -> {
            Predicate<Monto> filtered=monto -> monto.getMontoType().equals("Gastos");
            tablaMontoTV.setItems(
                    MontoList.getInstance().getMontos().filtered(filtered)
            );
        });

        verTodoBtn.setOnAction(action->{
            tablaMontoTV.setItems(
                    MontoList.getInstance().getMontos()
            );
        });

        eliminarMontoBtn.setOnAction(action->{
            Monto selectedMonto = tablaMontoTV.getSelectionModel().getSelectedItem();
            if (selectedMonto != null) {
                MontoList.getInstance().getMontos().remove(selectedMonto);
            }

        });


    }

}

