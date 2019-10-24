package sbrf.hackaton.cit.explorer;

import sbrf.hackaton.cit.core.*;

import java.util.LinkedHashMap;
import java.util.LinkedList;

/**
 * Created by Komyshenets on 28.09.2019.
 */
public class ВfsExplorer3 implements Explorer {
    private final LinkedList<Vertex> visited = new LinkedList<>();
    private final LinkedHashMap<Vertex, Double> costs = new LinkedHashMap<>();
    private final LinkedHashMap<Vertex, RouteBlock<? extends Edge, ? extends Vertex>> parents = new LinkedHashMap<>();
    private final LinkedList<RouteBlock<? extends Edge, ? extends Vertex>> queue = new LinkedList<>();

    private final Cursor cursor;
    private Route route = null;


    public ВfsExplorer3(Cursor cursor) {
        this.cursor = cursor;
    }


    public FixedRoute routeSearch(Vertex startPoint) {

        RouteBlock<Edge, Vertex> startBlock = new RouteBlock<>(null, startPoint);
        routeSearch(startBlock);
        return new FixedRoute(route);
    }

    private void routeSearch(RouteBlock<Edge, Vertex> startBlock) {
        cursor.goToPoint(startBlock);
        for (RouteBlock route : startBlock.getPossibleDirections()) {
            if (cursor.isAvailableWay(route)) {

            }
        }
    }

    private void buildWay(Vertex startVertex) {
        RouteBlock<? extends Edge, ? extends Vertex> parentBlock = parents.get(startVertex);
        Vertex parentVertex = parentBlock.getVertex();
        System.out.println("b: " + startVertex + "," + costs.get(parentVertex));

        if (!startVertex.equals(parentVertex)) {
            buildWay(parentVertex);
        }
        route.addDestination(parentBlock);
    }


    private void addFoundRoute(FixedRoute route) {
        System.out.print("|" + route.blocks.size() + "|");
//        System.out.println("Fix " + cursor + "\n" + route);
        if (this.route == null || this.route.getCost() < route.getCost())
            this.route = route;
    }


}
