package sbrf.hackaton.cit.domain.route;

public class FixedRoute extends DynamicRoute {
    private final double atmVal;
    private final double roadVal;

    public FixedRoute(DynamicRoute route) {
        this.currentATMs.addAll(route.currentATMs);
        this.currentRoads.addAll(route.currentRoads);

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
