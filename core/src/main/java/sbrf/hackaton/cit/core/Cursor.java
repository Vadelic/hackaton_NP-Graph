package sbrf.hackaton.cit.core;

public abstract class Cursor {
    protected final Route currentRoute = new Route();

    protected int timeMax;
    protected int moneyMax;

    public Cursor(int time, int weight) {
        this.timeMax = time;
        this.moneyMax = weight;
    }

    /**
     * Создает объект состояния в момент вызова
     */
    public FixedRoute fixRoute() {
//        Route route = new Route();
//        route.vertexes.addAll(currentRoute.vertexes);
//        route.edges.addAll(currentRoute.edges);
//        return route;
        return new FixedRoute(currentRoute);
    }

    /**
     * Вызывается при перемещении к точке
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
     * проверка может ли курсор сместиться к указаной точке
     * не превысила ли сумма вершин maximumMoney
     * <p>
     * не привышает ли расч>тный путь максимальнодопустимое значение
     */
    public boolean isAvailableWay(Edge targetRoad, Vertex targetPoint) {
        return availablePoint(targetPoint) && availableRoad(targetRoad, targetPoint.getFinalRoute().getEdge());
    }

    /**
     * проверка нет ли перегруза в данной точке
     */
    private boolean availablePoint(Vertex targetVert) {
        return currentRoute.getVertexValue() + targetVert.getValue() <= leftVertexValue();
    }

    protected double leftVertexValue() {
        return moneyMax;
    }

    /**
     * проверяет подходит ли этот маршруи с уч>том времени на возвращение
     */
    private boolean availableRoad(Edge targetRoad, Edge finalRoad) {
        double targetRoadDistance;
        if (currentRoute.edges.isEmpty()) {
            targetRoadDistance = targetRoad.getDistanceWithTraffic();
        } else {
            targetRoadDistance = targetRoad.getDistanceWithHigherTraffic();
        }
        double finalRoadDistance = finalRoad.getDistanceWithHigherTraffic();

        return currentRoute.getEdgesValue() + targetRoadDistance + finalRoadDistance <= leftEdgeValue();
    }

    protected double leftEdgeValue() {
        // TODO: 21/10/2019  
        return timeMax;
    }
}
