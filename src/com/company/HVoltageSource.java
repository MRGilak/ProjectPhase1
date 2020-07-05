package com.company;

import java.util.ArrayList;
import java.util.List;

public class HVoltageSource {//Current controlled voltage source
    public static List<HVoltageSource> allHVoltageSources = new ArrayList<HVoltageSource>();

    String name;
    Node node1;
    Node node2;
    IElement element;
    double a;

    HVoltageSource(String name, Node node1, Node node2, String string, double a) { //constructor of the class
        this.name = name;
        this.node1 = node1;
        this.node2 = node2;
        this.element = Main.findElement(string);
        this.a = a;
        allHVoltageSources.add(this);
    }//End of the constructor

    double getVoltage(double time) {
        return a * (element.getCurrent(time));
    }
}
