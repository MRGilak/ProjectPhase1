package com.company;

public class CurrentSource {
    String name;
    Node node1;
    Node node2;
    double current;

    CurrentSource(String name, Node node1, Node node2, double current) {
        this.name = name;
        this.node1 = node1;
        this.node2 = node2;
        this.current = current;
    }

    double getCurrent(double time) {
        return current;
    }
}
