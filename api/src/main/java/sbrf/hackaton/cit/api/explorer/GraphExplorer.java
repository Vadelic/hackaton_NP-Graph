package sbrf.hackaton.cit.api.explorer;

import sbrf.hackaton.cit.api.Cursor;
import sbrf.hackaton.cit.api.Edge;
import sbrf.hackaton.cit.api.Route;
import sbrf.hackaton.cit.api.Vertex;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Komyshenets on 28.09.2019.
 */
public class GraphExplorer implements Explorer {
    final List<? extends Vertex> destinationPoint;
    final Cursor cursor;
    final List<Route> routes = new LinkedList<>();

    public GraphExplorer(List<? extends Vertex> destinationPoints, Cursor cursor) {
        this.destinationPoint = destinationPoints;
        this.cursor = cursor;
    }

    @Override
    public void routeSearch(Vertex startPoint) {
        routes.clear();
        routeSearch(null, startPoint);
    }

    private void routeSearch(Edge road, Vertex point) {
        cursor.goToPoint(road, point);
        if (!cursor.justStarted() && destinationPoint.contains(point)) {
            //We arrived at destination
            routes.add(cursor.fixRoute());
        } else {
            point.getPossibleRoutes().forEach((targetRoad, targetAtm) -> {
                if (cursor.availableRoot(targetRoad, targetAtm)) {
                    routeSearch(targetRoad, targetAtm);
                }
            });
        }
        cursor.removePointAndRoad();
    }


    @Override
    public List<Route> getAllAvailableRouts() {
        return routes;
    }

}
