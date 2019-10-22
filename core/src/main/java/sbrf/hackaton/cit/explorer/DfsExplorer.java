package sbrf.hackaton.cit.explorer;

import sbrf.hackaton.cit.core.*;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Komyshenets on 28.09.2019.
 */
public class DfsExplorer implements Explorer {
    private final LinkedList<Vertex> visited = new LinkedList<>();
    private final Cursor cursor;
    private FixedRoute route = null;


    public DfsExplorer(Cursor cursor) {
        this.cursor = cursor;
    }

    public FixedRoute routeSearch(Vertex startPoint) {
        visited.clear();
        routeSearch(null, startPoint);
        return route;
    }

    private void routeSearch(Edge road, Vertex point) {

        cursor.goToPoint(road, point);
        addFoundRoute(cursor.fixRoute());
        visited.addLast(point);
        List<RouteBlock> possibleRoutes = point.getPossibleRoutes();
        for (RouteBlock possibleRoute : possibleRoutes) {
            Vertex targetVert = possibleRoute.getVertex();
            if (visited.contains(targetVert)) {
                continue;
            }
            Edge targetRoad = possibleRoute.getEdge();
            if (cursor.isAvailableWay(targetRoad, targetVert)) {
                routeSearch(targetRoad, targetVert);
            }
        }
        visited.removeLast();
        cursor.removePointAndRoad();
    }


    private void addFoundRoute(FixedRoute route) {
        System.out.println("Fix " + cursor + "\n" + route);
        if (this.route == null || this.route.getCost() < route.getCost())
            this.route = route;
    }
}
