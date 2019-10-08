package sbrf.hackaton.cit;

import sbrf.hackaton.cit.api.Cursor;
import sbrf.hackaton.cit.api.Vertex;
import sbrf.hackaton.cit.api.explorer.Explorer;
import sbrf.hackaton.cit.api.explorer.GraphExplorer;
import sbrf.hackaton.cit.api.explorer.GraphRecursionExplorer;

import java.util.Collections;
import java.util.List;

public class ExplorerFactory {
    public static Explorer getRecursionExplorer(Vertex destinationPoint, Cursor cursor) {
        return getRecursionExplorer(Collections.singletonList(destinationPoint), cursor);
    }

    public static Explorer getRecursionExplorer(List<? extends Vertex> destinationPoints, Cursor cursor) {
        return new GraphRecursionExplorer(destinationPoints, cursor);
    }


    public static Explorer getExplorer(Vertex destinationPoint, Cursor cursor) {
        return getExplorer(Collections.singletonList(destinationPoint), cursor);
    }

    public static Explorer getExplorer(List<? extends Vertex> destinationPoints, Cursor cursor) {
        return new GraphExplorer(destinationPoints, cursor);
    }
}
