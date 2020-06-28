package com.company;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static double deltaT;

    static IElement findElement(String string) {
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

            if(string.startsWith("I")) {//This condition checks the command to build a inductor
                strings[0] = strings[0].substring(1);//The first letter must be ignored

                CurrentSource currentSource = new CurrentSource(strings[0], node1, node2, number(strings[3]), number(strings[4]), number(strings[5]), number(strings[6]));
                CurrentSource.allCurrentSources.add(currentSource);
            }//End of condition 'Current Source'

            if(string.startsWith("V")) {//This condition checks the command to build a inductor
                strings[0] = strings[0].substring(1);//The first letter must be ignored

                VoltageSource voltageSource = new VoltageSource(strings[0], node1, node2, number(strings[3]), number(strings[4]), number(strings[5]), number(strings[6]));
                VoltageSource.allVoltageSources.add(voltageSource);
            }//End of condition 'Voltage Source'
        }//End of condition
    }//End of function StringAnalyzer

    //We should check for the suffixes p, n, u, m, k, M, G
    static Double number(String string) {
        double number, rawNumber;
        rawNumber = Double.parseDouble(string.substring(0, string.length()-1));

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

    public static void main(String[] args) {

    }//End of function main
}
