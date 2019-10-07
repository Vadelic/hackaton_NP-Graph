package sbrf.hackaton.cit.domain.atm;

/**
 * Created by Komyshenets on 25.09.2019.
 */
public class AtmImpl extends Atm {


    private double value;

    public AtmImpl(double value) {
        this.value = value;

    }

    @Override
    public double getMoney() {
        return value;
    }

    @Override
    public String toString() {
        return index + " (" + value + ")";
    }



}
