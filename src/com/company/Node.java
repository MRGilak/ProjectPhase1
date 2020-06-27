package com.company;

import java.util.List;

public class Node {
    public static List<Node> allNodes;

    String name;
    double voltage;

    Node(String name) {
        this.name = name;
    }

    double getVoltage() {
        return voltage;
    }

    static Node find(String name) {
        for(Node node : allNodes) {
            if(node.name.equals(name)) {
                return node;
            }
        }

        return null;
    }
}//End of class Node
