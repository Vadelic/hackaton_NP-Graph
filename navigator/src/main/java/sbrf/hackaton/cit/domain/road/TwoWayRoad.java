package sbrf.hackaton.cit.domain.road;


import sbrf.hackaton.cit.domain.Atm;

import java.util.Objects;

/**
 * Created by Komyshenets on 25.09.2019.
 */
public class TwoWayRoad extends Road {


    public TwoWayRoad(Atm from, Atm to, double distance) {
        super(from, to, distance);

    }

    @Override
    public String toString() {
        return String.format("(%s)-%.2f-(%s)", getLeft(), getDistance(), getRight());
    }


    @Override
    public Atm getTarget(Atm from) {
        if (!Objects.equals(from, getLeft())) return getLeft();
        if (!Objects.equals(from, getRight())) return getRight();
        return null;
    }

}


