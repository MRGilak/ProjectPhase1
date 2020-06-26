package com.company;

public class Capacitor implements Element {
    String name;
    Node node1;
    Node node2;
    double capacity;//the electrical argument shown by 'C'
    double initialVoltage;//the electrical argument shown by 'V0'

    Capacitor(String name, Node node1, Node node2, double capacity, double initialVoltage) {
        this.name = name;
        this.node1 = node1;
        this.node2 = node2;
        this.capacity = capacity;
        this.initialVoltage = initialVoltage;
    }

    double getVoltage(double time) {
        double I = 0;
        for(int k = 1; k <= (time / Main.deltaT); k++) {
            I += getCurrent(k * Main.deltaT) * Main.deltaT;
        }

        return initialVoltage + (I / capacity);
    }

    double getCurrent(double time) {
        return capacity * ((getVoltage(time + Main.deltaT) - getVoltage(time)) / Main.deltaT);
    }

    public double getPower(double time) {
        return getVoltage(time) * getCurrent(time);
    }
}
