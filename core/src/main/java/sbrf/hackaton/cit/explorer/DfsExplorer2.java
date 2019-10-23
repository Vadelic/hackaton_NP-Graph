package sbrf.hackaton.cit.explorer;

import sbrf.hackaton.cit.core.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

/**
 * Created by Komyshenets on 28.09.2019.
 */
public class DfsExplorer2 implements Explorer {
    private final LinkedList<Vertex> visited = new LinkedList<>();
    private Cursor cursor;
    private FixedRoute route = null;
    private int count = 0;


    public DfsExplorer2(Cursor cursor) {
        this.cursor = cursor;
        visited.addAll(cursor.getWay());
    }

    public DfsExplorer2() {

    }

    public void setCursor(Cursor cursor) {
        this.cursor = cursor;
    }

    public FixedRoute routeSearch(Vertex startPoint) {
        visited.clear();

        routeSearch(null, startPoint);

        return route;
    }

    public FixedRoute getRoute() {
        return route;
    }

    public void routeSearch(Edge road, Vertex point) {

        cursor.goToPoint(road, point);
        addFoundRoute(cursor.fixRoute());
        visited.addLast(point);
        List<RouteBlock> possibleRoutes = point.getPossibleRoutes();
        List<Future<FixedRoute>> submits = new ArrayList<>();
        List<Callable<FixedRoute>> collect = possibleRoutes.stream()
                .filter(routeBlock -> !visited.contains(routeBlock.getVertex()))
                .filter(routeBlock -> {
                    Edge targetRoad = routeBlock.getEdge();
                    Vertex targetVert = routeBlock.getVertex();
                    return cursor.isAvailableWay(targetRoad, targetVert);
                })
                .map(routeBlock -> (Callable<FixedRoute>) () -> {
                    Explorer dfsExplorer = new DfsExplorer(cursor.clone());
                    dfsExplorer.routeSearch(routeBlock.getEdge(), routeBlock.getVertex());
                    return dfsExplorer.getRoute();
                })
                .collect(Collectors.toList());
        try {
            List<Future<FixedRoute>> futures = Executors.newSingleThreadExecutor().invokeAll(collect);
            for (Future<FixedRoute> future : futures) {
                addFoundRoute(future.get());
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        //        visited.removeLast();
//        cursor.removePointAndRoad();
//        for (RouteBlock possibleRoute : possibleRoutes) {
//            Vertex targetVert = possibleRoute.getVertex();
//            if (visited.contains(targetVert)) {
//                continue;
//            }
//            Edge targetRoad = possibleRoute.getEdge();
//            ExecutorService executorService = Executors.newCachedThreadPool();
//            if (cursor.isAvailableWay(targetRoad, targetVert)) {
//                DfsExplorer dfsExplorer2 = new DfsExplorer(cursor.clone());
//                Future<FixedRoute> submit = executorService.submit(() -> dfsExplorer2.routeSearch(targetVert));
//                submits.add(submit);
//            }
//
//        }
//        for (Future<FixedRoute> future : submits) {
//            try {
//                FixedRoute fixedRoute = future.get();
//                addFoundRoute(fixedRoute);
//            } catch (InterruptedException | ExecutionException e) {
//                e.printStackTrace();
//            }
//        }
    }


    private void addFoundRoute(FixedRoute route) {
        if (route != null) {

//        System.out.println("Fix " + cursor + "\n" + route);
            System.out.print(Thread.currentThread().getName() + " " + ++count + "-" + route.vertexes.size() + "|");
            if (this.route == null || this.route.getCost() < route.getCost()) {
                this.route = route;
            }
        }
    }
}
