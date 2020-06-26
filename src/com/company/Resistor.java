package com.company;

public class Resistor implements Element {
    String name;
    Node node1;
    Node node2;

    double resistance;//the electrical argument shown by 'R'

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
