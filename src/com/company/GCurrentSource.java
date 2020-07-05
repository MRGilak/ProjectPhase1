package com.company;

import java.util.ArrayList;
import java.util.List;

public class GCurrentSource {//Voltage controlled current source
    public static List<GCurrentSource> allGCurrentSources = new ArrayList<GCurrentSource>();

    String name;
    Node node1;
    Node node2;
    Node nodeIn;
    Node nodeOut;
    double a;

    GCurrentSource(String name, Node node1, Node node2, Node nodeIn, Node nodeOut, double a) { //constructor of the class
        this.name = name;
        this.node1 = node1;
        this.node2 = node2;
        this.nodeIn = nodeIn;
        this.nodeOut = nodeOut;
        this.a = a;
    }//End of the constructor

    double getCurrent(double time) {
        return a * (nodeIn.getVoltage(time) - nodeOut.getVoltage(time));
    }
}
