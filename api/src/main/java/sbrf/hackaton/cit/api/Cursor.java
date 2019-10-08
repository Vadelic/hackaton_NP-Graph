package sbrf.hackaton.cit.api;

import java.util.LinkedList;
import java.util.List;

public abstract class Cursor {

    protected final Route currentRoute = new Route();

    private final int maximumTime;
    private final int maximumMoney;
    private final List<Route> completeRoutes = new LinkedList<>();

    public Cursor(int time, int weight) {
        this.maximumTime = time;
        this.maximumMoney = weight;
    }

    /**
     * Создает объект состояния в момент вызова
     */
    public abstract Route fixRoute();

    /**
     * Вызывается при перемещении к точке
     *
     * @param road
     * @param point
     */
    public void goToPoint(Edge road, Vertex point) {
        currentRoute.addDestination(road, point);

    }


    /**
     * Вызывается когда смещается на предыдущую позицию
     */

    public void removePointAndRoad() {
        currentRoute.removeLastDestination();
    }

    /**
     * Проверка неявляется ли это первая точка в маршруте
     */
    public boolean justStarted() {
        return currentRoute.getCountPoint() <= 1;
    }


    /**
     * проверка может ли объект сместиться к указаной точке
     *
     * @param targetRoad
     * @param targetPoint
     */
    public boolean availableRoot(Edge targetRoad, Vertex targetPoint) {
        return availableRoad(targetRoad) && availablePoint(targetPoint);
    }

    private boolean availablePoint(Vertex targetAtm) {
        double sum = currentRoute.getVertexValue();
        if (!currentRoute.containsAtm(targetAtm))
            sum += targetAtm.getValue();
        return sum <= maximumMoney;
    }

    private boolean availableRoad(Edge targetRoad) {
        double usedTime = completeRoutes.stream().mapToDouble(Route::getEdgesValue).sum();
        return currentRoute.getEdgesValue() + targetRoad.getDistance() <= maximumTime - usedTime;
    }

    public void visitRoute(Route bestRoute) {
        bestRoute.visit();
        completeRoutes.add(bestRoute);
    }

    public List<Route> getCompleteRoutes() {
        return completeRoutes;
    }

}
