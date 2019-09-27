package sbrf.hackaton.cit.domain;

import sbrf.hackaton.cit.api.Vertex;

/**
 * Created by Komyshenets on 25.09.2019.
 */
public class Atm extends Vertex  {
    private final int value;
     private int marker;

    public Atm(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public Integer marker() {
        return marker;
    }
}
