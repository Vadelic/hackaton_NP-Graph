package sbrf.hackaton.cit.domain;


import java.util.Objects;

/**
 * Created by Komyshenets on 25.09.2019.
 */
public class Road  {
    private Atm[] nodes = new Atm[2];
    protected Integer value;

    public Road(int distance) {
        this.value = distance;
    }

    @Override
    public String toString() {
        return String.format("(%s)-%d-(%s)", getLeft(), getDistance(), getRight());
    }

    int getDistance() {
        return value;
    }

    public void addAtm(Atm left, Atm right) {
        left.addRoad(this);
        nodes[0] = left;
        right.addRoad(this);
        nodes[1] = right;
    }

    private Atm getLeft() {
        return nodes[0];
    }

    private Atm getRight() {
        return nodes[1];
    }

    public Atm getTarget(Atm from) {
        if (!Objects.equals(from, getLeft())) return getLeft();
        if (!Objects.equals(from, getRight())) return getRight();
        return null;
    }

}


