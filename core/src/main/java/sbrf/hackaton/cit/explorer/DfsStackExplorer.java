package sbrf.hackaton.cit.explorer;

import sbrf.hackaton.cit.core.Cursor;
import sbrf.hackaton.cit.core.Edge;
import sbrf.hackaton.cit.core.Route;
import sbrf.hackaton.cit.core.Vertex;

import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by Komyshenets on 28.09.2019.
 */
public class DfsStackExplorer extends ExplorerImpl {

    public DfsStackExplorer(List<? extends Vertex> destinationPoints, Cursor cursor) {
        super(destinationPoints, cursor);
    }

    private ConcurrentLinkedQueue<Direction> stack = new ConcurrentLinkedQueue<>();

    public List<Route> routeSearch(Vertex startPoint) {
        routes.clear();
        stack.offer(new Direction(null, startPoint));
        routeSearch(null, null);
        return routes;
    }

    private void routeSearch(Edge road, Vertex point) {
        Direction poll = stack.poll();
    }


    private class Direction {
        Edge edge;
        Vertex vertex;

        public Direction(Edge edge, Vertex vertex) {
            this.edge = edge;
            this.vertex = vertex;
        }
    }
}
