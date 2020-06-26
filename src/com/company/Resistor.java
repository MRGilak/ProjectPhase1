package com.company;

public class Resistor implements Element {
    String name;
    Node node1;
    Node node2;
    double resistance;//the electrical argument shown by 'R'

    Resistor(String name, Node node1, Node node2, double resistance) {
        this.name = name;
        this.node1 = node1;
        this.node2 = node2;
        this.resistance = resistance;
    }

    double getVoltage(double time) {
        return getCurrent(time) / resistance;
    }

    double getCurrent(double time) {
        return getVoltage(time) / resistance;
    }

    public double getPower(double time) {
        return getVoltage(time) * getCurrent(time);
    }
}
