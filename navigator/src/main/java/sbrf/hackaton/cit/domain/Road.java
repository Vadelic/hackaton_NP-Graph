package sbrf.hackaton.cit.domain;


import sbrf.hackaton.cit.core.Edge;

import java.util.Objects;

public class Road implements Edge {
    private static int count = 0;
    private final int index;
    private Atm[] nodes = new Atm[2];

    private final double value;

    public Road(Atm from, Atm to, double distance) {
        index = ++count;
        value = distance;
        addAtm(from, to);

    }

    private void addAtm(Atm left, Atm right) {
        nodes[0] = left;

        nodes[1] = right;
    }

    private Atm getFrom() {
        return nodes[0];
    }

    private Atm getTo() {
        return nodes[1];
    }

    public double getDistance() {
        return value;
    }

    @Override
    public String toString() {
        return String.format("(%s)-%.2f-(%s)", getFrom(), getDistance(), getTo());
    }


    Atm getTarget(Atm from) {
        if (!Objects.equals(from, getFrom())) return getFrom();
        if (!Objects.equals(from, getTo())) return getTo();
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Road road = (Road) o;
        return index == road.index;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index);
    }

}
