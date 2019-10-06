package sbrf.hackaton.cit.domain.road;


import sbrf.hackaton.cit.domain.Atm;

import java.util.Objects;

/**
 * Created by Komyshenets on 25.09.2019.
 */
public class TwoWayRoad extends Road {
    private Integer value;

    public TwoWayRoad(Atm vertexA, Atm vertexB, int distance) {
        super(vertexA, vertexB);
        this.value = distance;
    }

    @Override
    public String toString() {
        return String.format("(%s)-%d-(%s)", getLeft(), getDistance(), getRight());
    }

    public int getDistance() {
        return value;
    }

    @Override
    public Atm getTarget(Atm from) {
        if (!Objects.equals(from, getLeft())) return getLeft();
        if (!Objects.equals(from, getRight())) return getRight();
        return null;
    }

}


