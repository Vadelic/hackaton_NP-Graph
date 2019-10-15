package sbrf.hackaton.cit.explorer;

import sbrf.hackaton.cit.core.Cursor;
import sbrf.hackaton.cit.core.Edge;
import sbrf.hackaton.cit.core.Route;
import sbrf.hackaton.cit.core.Vertex;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by Komyshenets on 28.09.2019.
 */
public class DfsExplorer implements Explorer {

    private final List<? extends Vertex> destinationPoint;
    private final Cursor cursor;
    private final List<Route> routes = new LinkedList<>();

    public DfsExplorer(List<? extends Vertex> destinationPoints, Cursor cursor) {
        this.destinationPoint = destinationPoints;
        this.cursor = cursor;
    }

    public List<Route> routeSearch(Vertex startPoint) {
        routes.clear();
        routeSearch(null, startPoint);
        return routes;
    }

    private void routeSearch(Edge road, Vertex point) {
        cursor.goToPoint(road, point);
        if (!cursor.justStarted() && destinationPoint.contains(point)) {
            routes.add(cursor.fixRoute());
        } else {
            Map<? extends Edge, ? extends Vertex> possibleRoutes = point.getPossibleRoutes();
            for (Map.Entry<? extends Edge, ? extends Vertex> entry : possibleRoutes.entrySet()) {
                Vertex targetAtm = entry.getValue();
                Edge targetRoad = entry.getKey();
                if (cursor.availableRoot(targetRoad, targetAtm)) {
                    routeSearch(targetRoad, targetAtm);
                }
            }
        }
        cursor.removePointAndRoad();
    }


}
