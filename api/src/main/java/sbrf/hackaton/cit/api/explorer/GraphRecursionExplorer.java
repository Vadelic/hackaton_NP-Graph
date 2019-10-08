package sbrf.hackaton.cit.api.explorer;

import sbrf.hackaton.cit.api.Cursor;
import sbrf.hackaton.cit.api.Edge;
import sbrf.hackaton.cit.api.Vertex;

import java.util.List;
import java.util.Map;

/**
 * Created by Komyshenets on 28.09.2019.
 */
public class GraphRecursionExplorer extends GraphExplorer {

    public GraphRecursionExplorer(List<? extends Vertex> destinationPoints, Cursor cursor) {
        super(destinationPoints, cursor);
    }

    protected void routeSearch(Edge road, Vertex point) {
        cursor.goToPoint(road, point);
        if (!cursor.justStarted() && destinationPoint.contains(point)) {
            //We arrived at destination
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
