package sbrf.hackaton.cit.domain.road;


import sbrf.hackaton.cit.domain.Atm;

import java.util.Objects;

/**
 * Created by Komyshenets on 25.09.2019.
 */
public class OneWayRoad extends TwoWayRoad {


    public OneWayRoad(Atm from, Atm to, int lenL) {
        super(from, to, lenL);
    }

    @Override
    public String toString() {
        return String.format("(%s)->%d->(%s)", getLeft(), getDistance(), getRight());
    }

    @Override
    public Atm getTarget(Atm from) {
        if (!Objects.equals(from, getLeft())) return getLeft();
        return null;
    }
}


