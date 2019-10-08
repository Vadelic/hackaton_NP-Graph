package sbrf.hackaton.cit.api;

import sbrf.hackaton.cit.api.explorer.Explorer;
import sbrf.hackaton.cit.api.explorer.GraphExplorer;
import sbrf.hackaton.cit.api.explorer.GraphRecursionExplorer;

import java.util.Collections;
import java.util.List;

public class ExplorerFactory {
    public static Explorer getRecursionExplorer(Vertex destinationPoint, Cursor<? extends Edge, ? extends Vertex> cursor) {
        return getRecursionExplorer(Collections.singletonList(destinationPoint), cursor);
    }

    public static Explorer getRecursionExplorer(List<? extends Vertex> destinationPoints, Cursor<? extends Edge, ? extends Vertex> cursor) {
        return new GraphRecursionExplorer(destinationPoints, cursor);
    }


    public static Explorer getExplorer(Vertex destinationPoint, Cursor<? extends Edge, ? extends Vertex> cursor) {
        return getExplorer(Collections.singletonList(destinationPoint), cursor);
    }

    public static Explorer getExplorer(List<? extends Vertex> destinationPoints, Cursor<? extends Edge, ? extends Vertex> cursor) {
        return new GraphExplorer(destinationPoints, cursor);
    }
}
