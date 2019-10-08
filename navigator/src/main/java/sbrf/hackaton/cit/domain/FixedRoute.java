package sbrf.hackaton.cit.domain;

import sbrf.hackaton.cit.api.Route;

public class FixedRoute extends Route {
    private final double atmVal;
    private final double roadVal;

    FixedRoute(Route route) {
        this.vertexes.addAll(route.vertexes);
        this.edges.addAll(route.edges);

        atmVal = route.getVertexValue();
        roadVal = route.getEdgesValue();
    }

    @Override
    public double getEdgesValue() {
        return roadVal;
    }

    @Override
    public double getVertexValue() {
        return atmVal;
    }


}
