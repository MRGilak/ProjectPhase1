package com.company;

public class VoltageSource {
    String name;
    Node node1;
    Node node2;
    double voltage;

    VoltageSource(String name, Node node1, Node node2, double voltage) {
        this.name = name;
        this.node1 = node1;
        this.node2 = node2;
        this.voltage = voltage;
    }

    double getVoltage(double time) {
        return voltage;
    }
}
