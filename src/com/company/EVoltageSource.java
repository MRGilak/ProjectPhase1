package com.company;

import java.util.ArrayList;
import java.util.List;

public class EVoltageSource {//Voltage controlled voltage source
    public static List<EVoltageSource> allEVoltageSources = new ArrayList<EVoltageSource>();

    String name;
    Node node1;
    Node node2;
    Node nodeIn;
    Node nodeOut;
    double a;

    EVoltageSource(String name, Node node1, Node node2, Node nodeIn, Node nodeOut, double a) { //constructor of the class
        this.name = name;
        this.node1 = node1;
        this.node2 = node2;
        this.nodeIn = nodeIn;
        this.nodeOut = nodeOut;
        this.a = a;
        allEVoltageSources.add(this);
    }//End of the constructor

    double getVoltage(double time) {
        return a * (nodeIn.getVoltage(time) - nodeOut.getVoltage(time));
    }
}
