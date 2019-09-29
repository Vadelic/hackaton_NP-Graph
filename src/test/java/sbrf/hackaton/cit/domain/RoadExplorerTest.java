package sbrf.hackaton.cit.domain;


import com.sun.istack.internal.Nullable;

import java.util.Map;

/**
 * Created by Komyshenets on 25.09.2019.
 */
class RoadExplorerTest {
    private final Atm destinationPoint;

    public RoadExplorerTest(Atm destinationPoint) {
        this.destinationPoint = destinationPoint;
    }

    public void routeSearch(@Nullable Road road, Atm atm, Car car) {

        car.goToPoint(road, atm);

        if (!car.justStarted() && atm.equals(destinationPoint)) {
            //We arrived at destination
            car.fixRoot();
        } else {

            Map<Road, Atm> possibleRoutes = atm.getPossibleRoutes();


            for (Map.Entry<Road, Atm> entry : possibleRoutes.entrySet()) {
                Atm targetAtm = entry.getValue();
                Road targetRoad = entry.getKey();
                if (car.availableRoot(targetRoad, targetAtm)) {
                    routeSearch(targetRoad, targetAtm, car);
                }
            }
        }

        car.removePointAndRoad();
    }

}