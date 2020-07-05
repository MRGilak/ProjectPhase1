package com.company;

import java.util.ArrayList;
import java.util.List;

public class VoltageSource {
    public static List<VoltageSource> allVoltageSources = new ArrayList<VoltageSource>();

    String name;
    Node node1;
    Node node2;
    double constantVoltage;
    double domain;
    double frequency;
    double phase;

    VoltageSource(String name, Node node1, Node node2, double constantVoltage,  double domain, double frequency, double phase) { //constructor of the class
        this.name = name;
        this.node1 = node1;
        this.node2 = node2;
        this.constantVoltage = constantVoltage;
        this.domain = domain;
        this.frequency = frequency;
        this.phase = phase;
    }//End of the constructor

    double getVoltage(double time) {
        return constantVoltage + (domain * Math.sin(frequency * time + phase));
    }
}//End of class VoltageSource
