package sbrf.hackaton.cit.domain.route;

public class FixedRoute extends Route {
    private final double atmVal;
    private final double roadVal;

    public FixedRoute(Route route) {
        currentATMs.addAll(route.currentATMs);
        currentRoads.addAll(route.currentRoads);
        atmVal = route.getAtmValue();
        roadVal = route.getRoadValue();
    }

    @Override
    public double getRoadValue() {
        return roadVal;
    }

    @Override
    public double getAtmValue() {
        return atmVal;
    }
}
