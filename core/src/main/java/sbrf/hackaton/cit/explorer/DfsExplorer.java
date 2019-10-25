package sbrf.hackaton.cit.explorer;

import sbrf.hackaton.cit.core.*;

import java.util.*;

/**
 * Created by Komyshenets on 28.09.2019.
 */
public class DfsExplorer implements Explorer {
    private final LinkedList<Vertex> visited = new LinkedList<>();
    private final Cursor cursor;
    private final int depth;
    //    private FixedRoute route = null;
    private Map<Integer, FixedRoute> routes = new TreeMap<>();

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
        routes.clear();
        routeSearch(null, startPoint);
        Integer integer = routes.keySet().stream().max(Comparator.comparingInt(o -> o)).orElse(0);
        return routes.get(integer);
    }


    public void routeSearch(Edge edge, Vertex vertex) {
        RouteBlock<Edge, Vertex> startBlock = new RouteBlock<>(edge, vertex);
        cursor.goToPoint(startBlock);
        addFoundRoute(cursor.fixRoute());
        visited.addLast(vertex);
        List<RouteBlock> possibleRoutes = vertex.getPossibleRoutes();
        for (RouteBlock possibleRoute : possibleRoutes) {
            Vertex targetVert = possibleRoute.getVertex();
            if (visited.contains(targetVert) || cursor.length() >= depth) {
                continue;
            }
            Edge targetRoad = possibleRoute.getEdge();
            if (cursor.isAvailableWay(possibleRoute)) {
                routeSearch(targetRoad, targetVert);
            }
        }
        visited.removeLast();
        cursor.removePointAndRoad();
    }


    private void addFoundRoute(FixedRoute route) {
        int size = route.blocks.size();
        FixedRoute fixedRoute = routes.get(size);

//        System.out.print("|" + ++count + "-" + route.blocks.size() + "|");
//        System.out.println("Fix " + cursor + "\n" + route);
        if (fixedRoute == null || fixedRoute.getCost() < route.getCost())
            if (priorityCondition(fixedRoute, route))
                routes.put(size, route);
    }

    private boolean priorityCondition(FixedRoute oldR, FixedRoute newR) {
        if (oldR == null)
            return true;
        return oldR.priorityValue() < newR.priorityValue();

    }
}
