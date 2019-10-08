package sbrf.hackaton.cit.explorer;

import sbrf.hackaton.cit.api.Cursor;
import sbrf.hackaton.cit.api.Edge;
import sbrf.hackaton.cit.api.Vertex;

import java.util.List;

/**
 * Created by Komyshenets on 28.09.2019.
 */
public class GraphExplorer extends ExplorerImpl implements Explorer {

    public GraphExplorer(List<? extends Vertex> destinationPoints, Cursor cursor) {
        super(destinationPoints, cursor);
    }

    protected void routeSearch(Edge road, Vertex point) {
        cursor.goToPoint(road, point);
        if (!cursor.justStarted() && destinationPoint.contains(point)) {
            routes.add(cursor.fixRoute());
        } else {
            point.getPossibleRoutes().forEach((targetRoad, targetAtm) -> {
                if (cursor.availableRoot(targetRoad, targetAtm)) {
                    routeSearch(targetRoad, targetAtm);
                }
            });
        }
        cursor.removePointAndRoad();
    }


}
