package ru.ilya;

import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Set<GraphGenerator.Edge> edges = GraphGenerator.generate(10, .8f);
        for (GraphGenerator.Edge edge : edges) {
            System.out.println(edge);
        }
    }
}
