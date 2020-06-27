package com.company;

import java.util.List;

public class CurrentSource {
    public static List<CurrentSource> allCurrentSources;

    String name;
    Node node1;
    Node node2;
    double current;

    CurrentSource(String name, Node node1, Node node2, double current) { //constructor of the class
        this.name = name;
        this.node1 = node1;
        this.node2 = node2;
        this.current = current;
    }//End of the constructor

    double getCurrent(double time) {
        return current;
    }
}//End of class CurrentSource
