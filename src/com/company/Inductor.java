package com.company;

public class Inductor implements Element {
    Node node1;
    Node node2;

    double Induction;//the electrical argument shown by 'L'
    double initialCurrent;//the electrical argument shown by 'I0'

    double getVoltage(double time) {
        return Induction * ((getCurrent(time + Main.deltaT) - getCurrent(time)) / Main.deltaT);
    }

    double getCurrent(double time) {
        double V = 0;
        for(int k = 1; k <= (time / Main.deltaT); k++) {
            V += getVoltage(k * Main.deltaT) * Main.deltaT;
        }

        return initialCurrent + (V / Induction);
    }

    public double getPower(double time) {
        return getVoltage(time) * getCurrent(time);
    }
}
