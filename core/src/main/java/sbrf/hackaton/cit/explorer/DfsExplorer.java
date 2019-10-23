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
    private final int depth;
    private FixedRoute route = null;
    private int count = 0;


    public DfsExplorer(Cursor cursor) {
        this.cursor = cursor;
        depth = Integer.MAX_VALUE;
    }

    public DfsExplorer(Cursor cursor, int depth) {
        this.cursor = cursor;
        this.depth = depth;
    }

    public FixedRoute routeSearch(Vertex startPoint) {
        visited.clear();
        routeSearch(null, startPoint);
        return route;
    }

    @Override
    public FixedRoute getRoute() {
        return route;
    }

    public void routeSearch(Edge road, Vertex vertex) {

        cursor.goToPoint(road, vertex);
        addFoundRoute(cursor.fixRoute());
        visited.addLast(vertex);
        List<RouteBlock> possibleRoutes = vertex.getPossibleRoutes();
        for (RouteBlock possibleRoute : possibleRoutes) {
            Vertex targetVert = possibleRoute.getVertex();
            if (visited.contains(targetVert) || cursor.length() >= depth) {
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
        System.out.print("|" + ++count + "-" + route.edges.size() + "|");
//        System.out.println("Fix " + cursor + "\n" + route);
        if (this.route == null || this.route.getCost() < route.getCost())
            this.route = route;
    }
}
