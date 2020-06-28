package com.company;

import java.util.List;

public class Capacitor implements IElement {
    public static List<Capacitor> allCapacitors;

    String name;
    Node node1;
    Node node2;
    double capacity;//the electrical argument shown by 'C'
    double initialVoltage;//the electrical argument shown by 'V0'

    Capacitor(String name, Node node1, Node node2, double capacity, double initialVoltage) { //constructor of the class
        this.name = name;
        this.node1 = node1;
        this.node2 = node2;
        this.capacity = capacity;
        this.initialVoltage = initialVoltage;
    } //End of the constructor

    public double getVoltage(double time) {
        double I = 0;
        for(int k = 1; k <= (time / Main.deltaT); k++) {
            I += getCurrent(k * Main.deltaT) * Main.deltaT;
        }

        return initialVoltage + (I / capacity);
    }

    public double getCurrent(double time) {
        return capacity * ((getVoltage(time + Main.deltaT) - getVoltage(time)) / Main.deltaT);
    }

    public double getPower(double time) {
        return getVoltage(time) * getCurrent(time);
    }

    static Capacitor find(String name) {
        for(Capacitor capacitor : allCapacitors) {
            if(capacitor.name.equals(name)) {
                return capacitor;
            }
        }

        return null;
    }
}//End of class Element
