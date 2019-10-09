package sbrf.hackaton.cit.domain;

import sbrf.hackaton.cit.core.Cursor;

/**
 * Created by Komyshenets on 29.09.2019.
 */
public class Car extends Cursor {

    public Car(int time, int weight) {
        super(time, weight);
    }

    @Override
    public FixedRoute fixRoute() {
        return new FixedRoute(currentRoute);
    }
}
