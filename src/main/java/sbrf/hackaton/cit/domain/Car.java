package sbrf.hackaton.cit.domain;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Komyshenets on 29.09.2019.
 */
public class Car {
    //    private final Logger logger = Logger.getLogger(Car.class);
    private final LinkedList<Atm> currentPath = new LinkedList<>();
    private final LinkedList<Road> currentRoads = new LinkedList<>();

    private final List<LinkedList<Atm>> fixedPaths = new LinkedList<>();

    private final int maximumTime;
    private final int maximumMoney;

    public Car(int time, int weight) {
        this.maximumTime = time;
        this.maximumMoney = weight;
    }

    public void fixRoot() {
        //We arrived at destination
//todo
        LinkedList<Atm> clone = (LinkedList<Atm>) currentPath.clone();
        fixedPaths.add(clone);
//        logger.info("New route found: " + currentPath);
        System.out.println("New route found: " + currentPath);
    }

    public void goToPoint(Road road, Atm atm) {
        addPoint(atm);
        addRoad(road);
    }

    private void addPoint(Atm atm) {
        currentPath.addLast(atm);
    }

    private void addRoad(Road road) {
        if (road != null)
            currentRoads.addLast(road);
    }

    public void removePointAndRoad() {
        currentPath.removeLast();
        if (!currentRoads.isEmpty())
            currentRoads.removeLast();
    }

    public boolean justStarted() {
        return currentPath.size() <= 1;
    }

    public boolean availableRoot(Road targetRoad, Atm targetAtm) {
        return availableRoad(targetRoad) && availablePoint(targetAtm);
    }

    private boolean availablePoint(Atm targetAtm) {
        // todo
        int sum = currentPath.stream().map(Atm::getMoney).mapToInt(Integer::intValue).sum();
        if (!currentPath.contains(targetAtm))
            sum += targetAtm.getMoney();
        return sum <= maximumMoney;
    }

    private boolean availableRoad(Road targetRoad) {
        // todo
        return currentRoads.stream()
                .map(Road::getDistance).distinct().mapToInt(Integer::intValue).sum() + targetRoad.getDistance() <= maximumTime;

    }

    public List<LinkedList<Atm>> getAllAvailableRouts() {
        return fixedPaths;
    }
}
