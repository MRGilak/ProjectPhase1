package com.company;

import java.util.List;

public class VoltageSource {
    public static List<VoltageSource> allVoltageSources;

    String name;
    Node node1;
    Node node2;
    double voltage;

    VoltageSource(String name, Node node1, Node node2, double voltage) { //constructor of the class
        this.name = name;
        this.node1 = node1;
        this.node2 = node2;
        this.voltage = voltage;
    }//End of the constructor

    double getVoltage(double time) {
        return voltage;
    }
}//End of class VoltageSource
