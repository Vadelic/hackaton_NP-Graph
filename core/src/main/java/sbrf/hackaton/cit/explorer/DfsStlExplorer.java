package sbrf.hackaton.cit.explorer;

import sbrf.hackaton.cit.core.Edge;
import sbrf.hackaton.cit.core.Route;
import sbrf.hackaton.cit.core.Vertex;

import java.util.List;
import java.util.Stack;

@Deprecated
public class DfsStlExplorer<V extends Vertex, E extends Edge> implements Explorer {
    private V[] vertexes;
    private E[][] edges;
    private V finish;
    private Stack stack = new Stack();

    public DfsStlExplorer(V[] vertexes, E[][] edges, V finish) {
        this.vertexes = vertexes;
        this.edges = edges;
        this.finish = finish;
    }

    @Override
    public List<Route> routeSearch(Vertex startPoint) {
        return null;
    }
}
