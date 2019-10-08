package sbrf.hackaton.cit.api.explorer;

import sbrf.hackaton.cit.api.Cursor;
import sbrf.hackaton.cit.api.Edge;
import sbrf.hackaton.cit.api.Route;
import sbrf.hackaton.cit.api.Vertex;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Komyshenets on 28.09.2019.
 */
public class GraphExplorer implements Explorer {
    final List<? extends Vertex> destinationPoint;
    final Cursor car;
    final List<Route> fixedRoutes = new LinkedList<>();

    public GraphExplorer(Vertex destinationPoint, Cursor car) {
        this.destinationPoint = Collections.singletonList(destinationPoint);
        this.car = car;
    }

    public GraphExplorer(List<? extends Vertex> destinationPoints, Cursor cursor) {
        this.destinationPoint = destinationPoints;
        this.car = cursor;
    }

    @Override
    public void routeSearch(Vertex startPoint) {
        fixedRoutes.clear();
        routeSearch(null, startPoint);
    }

    private void routeSearch(Edge road, Vertex point) {
        car.goToPoint(road, point);
        if (!car.justStarted() && destinationPoint.contains(point)) {
            //We arrived at destination
            fixedRoutes.add(car.fixRoute());
        } else {
            point.getPossibleRoutes().forEach((targetRoad, targetAtm) -> {
                if (car.availableRoot(targetRoad, targetAtm)) {
                    routeSearch(targetRoad, targetAtm);
                }
            });
        }
        car.removePointAndRoad();
    }


    @Override
    public List<Route> getAllAvailableRouts() {
        return fixedRoutes;
    }

}
