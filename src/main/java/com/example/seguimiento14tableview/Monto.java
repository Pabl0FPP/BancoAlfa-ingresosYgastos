package com.example.seguimiento14tableview;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Monto {
    private String MontoType;
    private String descMonto;
    private LocalDate dateMonto;
    private double monto;

    private ArrayList<Monto> montos;

    public Monto(String montoType, String descMonto, LocalDate dateMonto, double monto) {
        MontoType = montoType;
        this.descMonto = descMonto;
        this.dateMonto = dateMonto;
        this.monto = monto;
    }

    public String getMontoType() {
        return MontoType;
    }

    public void setMontoType(String montoType) {
        MontoType = montoType;
    }

    public String getDescMonto() {
        return descMonto;
    }

    public void setDescMonto(String descMonto) {
        this.descMonto = descMonto;
    }

    public LocalDate getDateMonto() {
        return dateMonto;
    }

    public void setDateMonto(LocalDate dateMonto) {
        this.dateMonto = dateMonto;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public ArrayList<Monto> getMontos() {
        return montos;
    }

    public void setMontos(ArrayList<Monto> montos) {
        this.montos = montos;
    }
}
