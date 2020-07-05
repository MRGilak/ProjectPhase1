package com.company;
import com.sun.javafx.sg.prism.NGQuadCurve;
import sun.misc.GC;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static double deltaT;

    public static IElement findElement(String string) {
        String name = string.substring(1);
        if(string.startsWith("R")) {
            return Resistor.find(name);
        }

        else if(string.startsWith("C")) {
            return Capacitor.find(name);
        }

        else if(string.startsWith("L")) {
            return Inductor.find(name);
        }

        return null;
    }


    static void StringAnalyzer(String string) {//This function analyzes the entered command and summons the appropriate function or class
        String[] strings = string.split(" ");
        if(! string.startsWith("*")) {//The lines starting with '*' are comments
            //First we check to see if we need to build a new node (maybe it already exists)
            Node node1 = Node.find(strings[1]);
            Node node2 = Node.find(strings[2]);
            if(node1 == null) {
                node1 = new Node(strings[1]);
                Node.allNodes.add(node1);
            }
            if(node2 == null) {
                node2 = new Node(strings[2]);
                Node.allNodes.add(node2);
            }


            if(string.startsWith("R")) {//This condition checks the command to build a resistor
                strings[0] = strings[0].substring(1);//The first letter must be ignored
                Resistor resistor = new Resistor(strings[0], node1, node2, number(strings[3]));
                Resistor.allResistors.add(resistor);
            }//End of condition 'Resistor'

            if(string.startsWith("C")) {//This condition checks the command to build a capacitor
                strings[0] = strings[0].substring(1);//The first letter must be ignored
                double initialVoltage = 0;
                if(string.length() == 5)
                    initialVoltage = number(strings[4]);

                Capacitor capacitor = new Capacitor(strings[0], node1, node2, number(strings[3]), initialVoltage);
                Capacitor.allCapacitors.add(capacitor);
            }//End of condition 'Capacitor'

            if(string.startsWith("L")) {//This condition checks the command to build a inductor
                strings[0] = strings[0].substring(1);//The first letter must be ignored
                double initialCurrent = 0;
                if(string.length() == 5)
                    initialCurrent = number(strings[4]);

                Inductor inductor = new Inductor(strings[0], node1, node2, number(strings[3]), initialCurrent);
                Inductor.allInductors.add(inductor);
            }//End of condition 'Inductor'

            if(string.startsWith("I")) {//This condition checks the command to build a current source
                strings[0] = strings[0].substring(1);//The first letter must be ignored

                CurrentSource currentSource = new CurrentSource(strings[0], node1, node2, number(strings[3]), number(strings[4]), number(strings[5]), number(strings[6]));
                CurrentSource.allCurrentSources.add(currentSource);
            }//End of condition 'Current Source'

            if(string.startsWith("V")) {//This condition checks the command to build a voltage source
                strings[0] = strings[0].substring(1);//The first letter must be ignored

                VoltageSource voltageSource = new VoltageSource(strings[0], node1, node2, number(strings[3]), number(strings[4]), number(strings[5]), number(strings[6]));
                VoltageSource.allVoltageSources.add(voltageSource);
            }//End of condition 'Voltage Source'

            if(string.startsWith("E")) {//This condition checks the command to build a E voltage source
                strings[0] = strings[0].substring(1);//The first letter must be ignored

                EVoltageSource eVoltageSource = new EVoltageSource(strings[0], node1, node2, Node.find(strings[3]), Node.find(strings[4]), number(strings[5]));
                EVoltageSource.allEVoltageSources.add(eVoltageSource);
            }//End of condition 'E voltage Source'

            if(string.startsWith("H")) {//This condition checks the command to build a H voltage source
                strings[0] = strings[0].substring(1);//The first letter must be ignored

                HVoltageSource hVoltageSource = new HVoltageSource(strings[0], node1, node2, strings[3], number(strings[4]));
                HVoltageSource.allHVoltageSources.add(hVoltageSource);
            }//End of condition 'H voltage Source'

            if(string.startsWith("G")) {//This condition checks the command to build a G current source
                strings[0] = strings[0].substring(1);//The first letter must be ignored

                GCurrentSource gCurrentSource = new GCurrentSource(strings[0], node1, node2, Node.find(strings[3]), Node.find(strings[4]), number(strings[5]));
                GCurrentSource.allGCurrentSources.add(gCurrentSource);
            }//End of condition 'G current Source'

            if(string.startsWith("F")) {//This condition checks the command to build a F current source
                strings[0] = strings[0].substring(1);//The first letter must be ignored

                FCurrentSource fCurrentSource = new FCurrentSource(strings[0], node1, node2, strings[3], number(strings[4]));
                FCurrentSource.allFCurrentSources.add(fCurrentSource);
            }//End of condition 'F current Source'
        }//End of condition
    }//End of function StringAnalyzer

    //We should check for the suffixes p, n, u, m, k, M, G
    static Double number(String string) {
        double number, rawNumber;
        rawNumber = Double.parseDouble(string.trim().replaceAll("(p|n|u|m|k|M|G)", ""));

        if(string.endsWith("p"))
            number = rawNumber * Math.pow(10d, -12d);
        else if(string.endsWith("n"))
            number = rawNumber * Math.pow(10d, -9d);
        else if(string.endsWith("u"))
            number = rawNumber * Math.pow(10d, -6d);
        else if(string.endsWith("m"))
            number = rawNumber * Math.pow(10d, -3d);
        else if(string.endsWith("k"))
            number = rawNumber * Math.pow(10d, 3d);
        else if(string.endsWith("M"))
            number = rawNumber * Math.pow(10d, 6d);
        else if(string.endsWith("G"))
            number = rawNumber * Math.pow(10d, 9d);
        else
            number = Double.parseDouble(string);

        return number;
    }//End of function 'number'

    /*
    static void testCase() {
        System.out.println("Nodes:");
        for(Node node : Node.allNodes) {
            System.out.println("Node " + node.name);
        }

        System.out.println("Resistors:");
        for(Resistor resistor : Resistor.allResistors) {
            System.out.println("Resistor " + resistor.name + " " + resistor.node1.name + " " + resistor.node2.name + " " + resistor.resistance);
        }

        System.out.println("Capacitors:");
        for(Capacitor capacitor : Capacitor.allCapacitors) {
            System.out.println("Capacitor " + capacitor.name + " " + capacitor.initialVoltage + " " + capacitor.node1.name + " " + capacitor.node2.name);
        }

        System.out.println("Inductors:");
        for(Inductor inductor : Inductor.allInductors) {
            System.out.println("Inductor " + inductor.name + " " + inductor.initialCurrent + " " + inductor.node1.name + " " + inductor.node2.name);
        }

        System.out.println("Current Sources:");
        for(CurrentSource currentSource : CurrentSource.allCurrentSources) {
            System.out.println("Current Source " + currentSource.name + " " + currentSource.node1.name + " " + currentSource.node2.name + " " + currentSource.constantCurrent + " + " + currentSource.domain + " * Sin( " + currentSource.frequency + " t + " + currentSource.phase + ")");
        }

        System.out.println("Voltage Sources:");
        for(VoltageSource voltageSource : VoltageSource.allVoltageSources) {
            System.out.println("Voltage Source" + voltageSource.name + " " + voltageSource.node1.name + " " + voltageSource.node2.name + " " + voltageSource.constantVoltage + " + " + voltageSource.domain + " * Sin( " + voltageSource.frequency + " t + " + voltageSource.phase + ")");
        }

        System.out.println("E Voltage Sources:");
        for(EVoltageSource evoltageSource : EVoltageSource.allEVoltageSources) {
            System.out.println("E Voltage Source " + evoltageSource.name + " " + evoltageSource.node1.name + " " + evoltageSource.node2.name + " " + evoltageSource.nodeIn.name + " " + evoltageSource.nodeOut.name + " " + evoltageSource.a);
        }

        System.out.println("H Voltage Sources:");
        for(HVoltageSource hVoltageSource : HVoltageSource.allHVoltageSources) {
            System.out.println("H Voltage Source " + hVoltageSource.name + " " + hVoltageSource.node1.name + " " + hVoltageSource.node2.name + " " + hVoltageSource.element.getName() + " " + hVoltageSource.a);
        }

        System.out.println("G Current Sources:");
        for(GCurrentSource gCurrentSource : GCurrentSource.allGCurrentSources) {
            System.out.println("G Current Source " + gCurrentSource.name + " " + gCurrentSource.node1.name + " " + gCurrentSource.node2.name + " " + gCurrentSource.nodeIn.name + " " + gCurrentSource.nodeOut.name + " " + gCurrentSource.a);
        }

        System.out.println("F Current Sources:");
        for(FCurrentSource fCurrentSource : FCurrentSource.allFCurrentSources) {
            System.out.println("F Current Source " + fCurrentSource.name + " " + fCurrentSource.node1.name + " " + fCurrentSource.node2.name + " " + fCurrentSource.element.getName() + " " + fCurrentSource.a);
        }
    }
    */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> strings = new ArrayList<String>();

        String enter = sc.nextLine();
        while(! enter.equals("END")) {
            strings.add(enter);
            enter = sc.nextLine();
        }

        for(String string : strings) {
            StringAnalyzer(string);
        }

        //testCase();
    }//End of function main
}
