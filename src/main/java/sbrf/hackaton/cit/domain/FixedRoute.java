package sbrf.hackaton.cit.domain;

public class FixedRoute extends Route {
    final int atmVal;
    final int roadVal;

    public FixedRoute(Route route) {
        currentATMs.addAll(route.currentATMs);
        currentRoads.addAll(route.currentRoads);
        atmVal = route.getAtmValue();
        roadVal = route.getRoadValue();
    }

    @Override
    int getRoadValue() {
        return roadVal;
    }

    @Override
    int getAtmValue() {
        return atmVal;
    }
}
