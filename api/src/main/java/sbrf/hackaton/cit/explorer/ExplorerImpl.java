package sbrf.hackaton.cit.explorer;

import sbrf.hackaton.cit.api.Cursor;
import sbrf.hackaton.cit.api.Edge;
import sbrf.hackaton.cit.api.Route;
import sbrf.hackaton.cit.api.Vertex;

import java.util.LinkedList;
import java.util.List;

public abstract class ExplorerImpl {
    final List<? extends Vertex> destinationPoint;
    final Cursor cursor;
    final List<Route> routes = new LinkedList<>();

    ExplorerImpl(List<? extends Vertex> destinationPoints, Cursor cursor) {
        this.destinationPoint = destinationPoints;
        this.cursor = cursor;
    }

    public void routeSearch(Vertex startPoint) {
        routes.clear();
        routeSearch(null, startPoint);
    }

    abstract void routeSearch(Edge road, Vertex point);

    public List<Route> getAllAvailableRouts() {
        return routes;
    }
}
