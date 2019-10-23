package sbrf.hackaton.cit.core;

import java.util.ArrayList;
import java.util.Objects;
import java.util.StringJoiner;

public class FixedRoute extends Route {

    public FixedRoute(Route route) {
        this.vertexes.addAll(route.vertexes);
        this.edges.addAll(route.edges);

        RouteBlock finalBlock = route.vertexes.getLast().getFinalBlock();
        if (Objects.nonNull(finalBlock))
            addDestination(finalBlock.getEdge(), finalBlock.getVertex());

    }

    public double getFinalEdgeValue() {
        try {
            return edges.getLast().getDistanceWithHigherTraffic();
        } catch (Exception e) {
            return 0;
        }
    }

    public RouteBlock getFirstDestination() {
        Vertex vertex = vertexes.get(1);
        Edge edge = edges.get(0);
        return new RouteBlock<>(edge, vertex);
    }

    public double getCost() {
        double vertValue = getVertexValue();
        double edgeValue = getEdgesValue();
        return vertValue / edgeValue;
    }

    public ArrayList<RouteBlock> getPlanedPath() {
        ArrayList<RouteBlock> routeBlocks = new ArrayList<>();
        if (edges.size() > 1)
            for (int i = 1; i < edges.size(); i++) {
                RouteBlock block = new RouteBlock<>(edges.get(i), vertexes.get(i + 1));
                routeBlocks.add(block);
            }
        return routeBlocks;
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(",");
        for (Edge edge : edges) {
            stringJoiner.add("\n" + edge.toString());
        }
        return new StringJoiner(", ", this.getClass().getSimpleName() + "[", "]")
                .add("points=" + vertexes)
                .add(stringJoiner.toString())
                .add("\nvertex:" + getVertexValue())
                .add("edge:" + getEdgesValue())
                .add("cost:" + getCost() + "\n")
                .toString();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
