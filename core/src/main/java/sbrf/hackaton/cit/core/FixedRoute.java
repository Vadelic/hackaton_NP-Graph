package sbrf.hackaton.cit.core;

import java.util.ArrayList;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class FixedRoute extends Route {

    public FixedRoute(Route route) {
        this.blocks.addAll(route.blocks);

        RouteBlock finalBlock = route.blocks.getLast().getFinalBlock();
        if (Objects.nonNull(finalBlock))
            addDestination(finalBlock);

    }

    public double getFinalEdgeValue() {
        try {
            return blocks.getLast().getDistanceWithHigherTraffic();
        } catch (Exception e) {
            return 0;
        }
    }

    public RouteBlock getFirstDestination() {
        if (blocks.size() > 1)
            return blocks.get(1);
        else
            return null;
    }

    public double getCost() {
        double vertValue = getVertexValue();
        double edgeValue = getEdgesValue();
        return vertValue / edgeValue;
    }

    public ArrayList<RouteBlock> getPlanedPath() {
        ArrayList<RouteBlock> routeBlocks = new ArrayList<>();

        if (blocks.size() > 2)
            for (int i = 2; i < blocks.size(); i++) {
                routeBlocks.add(blocks.get(i));
            }
        return routeBlocks;
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(",");
        for (Edge edge : blocks.stream().map(RouteBlock::getEdge).filter(Objects::nonNull).collect(Collectors.toList())) {
            stringJoiner.add("\n" + edge.toString());
        }
        return new StringJoiner(", ", this.getClass().getSimpleName() + "[", "]")
                .add("points=" + blocks.stream().map(RouteBlock::getVertex).collect(Collectors.toList()))
                .add(stringJoiner.toString())
                .add("\nvertex:" + getVertexValue())
                .add("edge:" + getEdgesValue())
                .add("cost:" + getCost())
                .toString();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
