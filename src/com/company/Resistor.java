package com.company;

import java.util.List;

public class Resistor implements Element {
    public static List<Resistor> allResistors;

    String name;
    Node node1;
    Node node2;
    double resistance;//the electrical argument shown by 'R'

    Resistor(String name, Node node1, Node node2, double resistance) { //constructor of the class
        this.name = name;
        this.node1 = node1;
        this.node2 = node2;
        this.resistance = resistance;
    } //End of constructor

    double getVoltage(double time) {
        return getCurrent(time) / resistance;
    }

    double getCurrent(double time) {
        return getVoltage(time) / resistance;
    }

    public double getPower(double time) {
        return getVoltage(time) * getCurrent(time);
    }
} //End of class Resistor
