package sbrf.hackaton.cit.explorer;

import sbrf.hackaton.cit.core.Cursor;
import sbrf.hackaton.cit.core.Route;
import sbrf.hackaton.cit.core.Vertex;

import java.util.LinkedList;
import java.util.List;

abstract class ExplorerImpl implements Explorer {
    final List<? extends Vertex> destinationPoint;
    final Cursor cursor;
    final List<Route> routes = new LinkedList<>();

    ExplorerImpl(List<? extends Vertex> destinationPoints, Cursor cursor) {
        this.destinationPoint = destinationPoints;
        this.cursor = cursor;
    }

}
