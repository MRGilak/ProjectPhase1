package com.company;

import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;
import java.util.List;

public class Resistor implements IElement {
    public static List<Resistor> allResistors = new ArrayList<Resistor>();

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

    public double getVoltage(double time) {
        return getCurrent(time) / resistance;
    }

    public double getCurrent(double time) {
        return getVoltage(time) / resistance;
    }

    public double getPower(double time) {
        return getVoltage(time) * getCurrent(time);
    }

    static Resistor find(String name) {
        for(Resistor resistor : allResistors) {
            if(resistor.name.equals(name)) {
                return resistor;
            }
        }

        return null;
    }

    public String getName() {
        return name;
    }
} //End of class Resistor
