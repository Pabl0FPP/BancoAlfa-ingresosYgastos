package com.example.seguimiento14tableview;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Comparator;

public class MontoList {

    ObservableList<Monto> montos= FXCollections.observableArrayList();

    public ObservableList<Monto> getMontos() {
        montos.sort(Comparator.comparing(Monto::getDateMonto));
        return montos;
    }

    public void setMontos(ObservableList<Monto> montos) {
        this.montos = montos;
    }

    //constructor privado/para no hacer instancias de contact list en otro lado
    private MontoList(){}

    private static MontoList instance =null;

    public static MontoList getInstance() {
        if (instance==null){
            instance=new MontoList();
        }
        return instance;
    }
}
