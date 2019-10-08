package sbrf.hackaton.cit.domain.road;


import sbrf.hackaton.cit.api.Edge;
import sbrf.hackaton.cit.domain.Atm;

import java.util.Objects;

public abstract class Road implements Edge {
    private static int count = 0;
    private final int index;
    private Atm[] nodes = new Atm[2];


    Road(Atm from, Atm to) {
        index = ++count;
        addAtm(from, to);

    }

    private void addAtm(Atm left, Atm right) {
        left.addRoad(this);
        nodes[0] = left;
        right.addRoad(this);
        nodes[1] = right;
    }

    Atm getLeft() {
        return nodes[0];
    }

    Atm getRight() {
        return nodes[1];
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

    public abstract Atm getTarget(Atm atm);

    public abstract double getDistance();
}
