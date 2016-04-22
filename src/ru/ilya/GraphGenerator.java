package ru.ilya;

import java.util.*;

/**
 * Created by user on 22.04.2016.
 */
public class GraphGenerator {

    public static Set<Edge> generate(int peaksCount, float requiredDensity) {
        if (requiredDensity < 0 && requiredDensity > 1) {
            throw new IllegalArgumentException("requiredDensity must be between 0 and 100");
        }
        Set<Edge> edges = new HashSet<>();
        Random rnd = new Random();
        float curDensity = 0f;
        while (curDensity <= requiredDensity) {
            int peak1 = rnd.nextInt(peaksCount);
            int peak2 = rnd.nextInt(peaksCount);
            if (peak1 != peak2) {
                edges.add(new Edge(peak1, peak2));
                curDensity = (2 * edges.size()) / (peaksCount * (peaksCount - 1));
            }
        }
        return edges;
    }

    public static class Edge {
        private int peak1, peak2;

        public Edge(int peak1, int peak2) {
            if (peak1 > peak2) {
                this.peak2 = peak1;
                this.peak1 = peak2;
            } else {
                this.peak1 = peak1;
                this.peak2 = peak2;
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Edge edge = (Edge) o;
            return peak1 == edge.peak1 && peak2 == edge.peak2;
        }

        @Override
        public int hashCode() {
            int result = peak1;
            result = 31 * result + peak2;
            return result;
        }

        @Override
        public String toString() {
            return peak1 + " " + peak2;
        }
    }
}
