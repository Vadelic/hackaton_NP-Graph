package sbrf.hackaton.cit.explorer;

import sbrf.hackaton.cit.core.*;

import java.util.LinkedHashMap;
import java.util.LinkedList;

/**
 * Created by Komyshenets on 28.09.2019.
 */
public class BfsExplorer implements Explorer {
    private final LinkedList<Vertex> visited = new LinkedList<>();
    private final LinkedHashMap<Vertex, Double> costs = new LinkedHashMap<>();
    private final LinkedHashMap<Vertex, RouteBlock<? extends Edge, ? extends Vertex>> parents = new LinkedHashMap<>();
    private final LinkedList<RouteBlock<? extends Edge, ? extends Vertex>> queue = new LinkedList<>();

    private final Cursor cursor;
    private Route route = null;


    public BfsExplorer(Cursor cursor) {
        this.cursor = cursor;
    }


    public FixedRoute routeSearch(Vertex startPoint) {

        RouteBlock<Edge, Vertex> startBlock = new RouteBlock<>(null, startPoint);
        visited.addLast(startBlock.getVertex());
        parents.put(startBlock.getVertex(), startBlock);
        costs.put(startBlock.getVertex(), startBlock.getCost());
        queue.addLast(startBlock);

        routeSearch();

        for (Vertex vertex : visited) {
            route = new Route();
            buildWay(vertex);


        }

        return new FixedRoute(route);
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

    private void routeSearch() {
        while (!queue.isEmpty()) {
            RouteBlock<? extends Edge, ? extends Vertex> parentBlock = queue.removeFirst();

            for (RouteBlock route : parentBlock.getPossibleDirections()) {
                if (isValidBlock(route)) {
                    visited.addLast(route.getVertex());
                    parents.put(route.getVertex(), parentBlock);
                    Double currentCost = costs.get(parentBlock.getVertex());
                    costs.put(route.getVertex(), (currentCost == null ? 0 : currentCost) + route.getCost());
                    queue.addLast(route);
                    doStep(parentBlock);
                }
            }
        }
    }

    private boolean isValidBlock(RouteBlock block) {

        return !visited.contains(block.getVertex())
                && cursor.isAvailableWay(block)
                ;

    }

    private void doStep(RouteBlock<? extends Edge, ? extends Vertex> routeBlock) {

    }

}
