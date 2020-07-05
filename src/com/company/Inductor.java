package com.company;

import java.util.ArrayList;
import java.util.List;

public class Inductor implements IElement {
    public static List<Inductor> allInductors = new ArrayList<Inductor>();

    String name;
    Node node1;
    Node node2;
    double induction;//the electrical argument shown by 'L'
    double initialCurrent;//the electrical argument shown by 'I0'

    Inductor(String name, Node node1, Node node2, double induction, double initialCurrent) { //constructor of the class
        this.name = name;
        this.node1 = node1;
        this.node2 = node2;
        this.induction = induction;
        this.initialCurrent = initialCurrent;
    }//End of the constructor

    public double getVoltage(double time) {
        return induction * ((getCurrent(time + Main.deltaT) - getCurrent(time)) / Main.deltaT);
    }

    public double getCurrent(double time) {
        double V = 0;
        for(int k = 1; k <= (time / Main.deltaT); k++) {
            V += getVoltage(k * Main.deltaT) * Main.deltaT;
        }

        return initialCurrent + (V / induction);
    }

    public double getPower(double time) {
        return getVoltage(time) * getCurrent(time);
    }

    static Inductor find(String name) {
        for(Inductor inductor : allInductors) {
            if(inductor.name.equals(name)) {
                return inductor;
            }
        }

        return null;
    }

    public String getName() {
        return name;
    }
}//End of class Inductor
