package com.company;

public class Capacitor implements Element {String name =  null;
    Node node1;
    Node node2;

    double capacity;//the electrical argument shown by 'C'
    double initialVoltage;//the electrical argument shown by 'V0'

    double getVoltage(double time) {
        double I = 0;
        for(int k = 1; k <= (time / Main.deltaT); k++) {
            I += getCurrent(k * Main.deltaT) * Main.deltaT;
        }

        return initialVoltage + (I / capacity);
    }

    double getCurrent(double time) {
        return capacity * ((getVoltage(time + Main.deltaT) - getVoltage(time)) / Main.deltaT);
    }

    public double getPower(double time) {
        return getVoltage(time) * getCurrent(time);
    }
}
