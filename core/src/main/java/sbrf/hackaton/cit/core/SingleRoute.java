package sbrf.hackaton.cit.core;

public class SingleRoute extends Route {

    public SingleRoute(RouteBlock route) {
        blocks.add(route);
    }

    public double getCost() {
        double vertValue = getVertexValue();
        double edgeValue = getEdgesValue();
        return vertValue / edgeValue;
    }

}
