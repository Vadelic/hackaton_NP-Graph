package sbrf.hackaton.cit.api.explorer;

import sbrf.hackaton.cit.api.Cursor;
import sbrf.hackaton.cit.api.Edge;
import sbrf.hackaton.cit.api.Vertex;

import java.util.List;
import java.util.Map;

/**
 * Created by Komyshenets on 28.09.2019.
 */
public class GraphRecursionExplorer extends GraphExplorer {


    public GraphRecursionExplorer(Vertex destinationPoint, Cursor car) {
        super(destinationPoint, car);
    }

    public GraphRecursionExplorer(List<? extends Vertex> destinationPoints, Cursor cursor) {
        super(destinationPoints, cursor);
    }

    private void routeSearch(Edge road, Vertex point) {
        car.goToPoint(road, point);
        if (!car.justStarted() && destinationPoint.contains(point)) {
            //We arrived at destination
            fixedRoutes.add(car.fixRoute());
        } else {
            Map<? extends Edge, ? extends Vertex> possibleRoutes = point.getPossibleRoutes();
            for (Map.Entry<? extends Edge, ? extends Vertex> entry : possibleRoutes.entrySet()) {
                Vertex targetAtm = entry.getValue();
                Edge targetRoad = entry.getKey();
                if (car.availableRoot(targetRoad, targetAtm)) {
                    routeSearch(targetRoad, targetAtm);
                }
            }
        }
        car.removePointAndRoad();
    }


}
