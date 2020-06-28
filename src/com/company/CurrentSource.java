package com.company;

import java.util.List;

public class CurrentSource {
    public static List<CurrentSource> allCurrentSources;

    String name;
    Node node1;
    Node node2;
    double constantCurrent;
    double domain;
    double frequency;
    double phase;

    CurrentSource(String name, Node node1, Node node2, double constantCurrent, double domain, double frequency, double phase) { //constructor of the class
        this.name = name;
        this.node1 = node1;
        this.node2 = node2;
        this.constantCurrent = constantCurrent;
        this.domain = domain;
        this.frequency = frequency;
        this.phase = phase;
    }//End of the constructor

    double getCurrent(double time) {
        return constantCurrent + (domain * Math.sin(frequency * time + phase));
    }
}//End of class CurrentSource
