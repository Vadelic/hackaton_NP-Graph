package sbrf.hackaton.cit.domain;

/**
 * Created by Komyshenets on 29.09.2019.
 */
public class Car {
    private final Route currentRoute = new Route();

    private final int maximumTime;
    private final int maximumMoney;

    public Car(int time, int weight) {
        this.maximumTime = time;
        this.maximumMoney = weight;
    }

    public Route fixRoot() {
        //We arrived at destination
        return currentRoute.clone();
    }

    public void goToPoint(Road road, Atm atm) {
        currentRoute.addDestination(road, atm);
    }


    public void removePointAndRoad() {
        currentRoute.removeLastDestination();
    }

    public boolean justStarted() {
        return currentRoute.getCountPoint() <= 1;
    }

    public boolean availableRoot(Road targetRoad, Atm targetAtm) {
        return availableRoad(targetRoad) && availablePoint(targetAtm);
    }

    private boolean availablePoint(Atm targetAtm) {
        int sum = currentRoute.getAtmValue();
        if (!currentRoute.containsAtm(targetAtm))
            sum += targetAtm.getMoney();
        return sum <= maximumMoney;
    }

    private boolean availableRoad(Road targetRoad) {
        return currentRoute.getRoadValue() + targetRoad.getDistance() <= maximumTime;
    }

}
