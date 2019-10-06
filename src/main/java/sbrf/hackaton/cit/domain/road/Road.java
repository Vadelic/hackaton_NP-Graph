package sbrf.hackaton.cit.domain.road;

import sbrf.hackaton.cit.domain.Atm;

import java.util.Objects;

public abstract class Road {
    private static int count = 0;
    private final int index;
    private Atm[] nodes = new Atm[2];


    Road(Atm vertexA, Atm vertexB) {
        index = ++count;
        addAtm(vertexA, vertexB);

    }

    private void addAtm(Atm left, Atm right) {
        left.addRoad(this);
        nodes[0] = left;
        right.addRoad(this);
        nodes[1] = right;
    }

    public abstract int getDistance();

    public abstract Atm getTarget(Atm from);

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
}
