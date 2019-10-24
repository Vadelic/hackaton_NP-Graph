package sbrf.hackaton.cit.core;

import java.util.stream.Collectors;

public abstract class Cursor implements Cloneable {
    protected final Route currentRoute = new Route();

    protected final int timeMax;
    protected final int moneyMax;

    public Cursor(int time, int weight) {
        this.timeMax = time;
        this.moneyMax = weight;
    }

    @Override
    public Cursor clone() {
        try {
            return (Cursor) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
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

    public void goToPoint(RouteBlock<Edge, Vertex> block) {
        currentRoute.addDestination(block);
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
    public boolean isAvailableWay(RouteBlock<? extends Edge, ? extends Vertex> block) {
        return availablePoint(block.getVertex())
                && availableRoad(block);

    }

    /**
     * проверка нет ли перегруза в данной точке
     */
    private boolean availablePoint(Vertex targetVert) {
        return !currentRoute.blocks.stream().map(RouteBlock::getVertex).collect(Collectors.toList()).contains(targetVert) && currentRoute.getVertexValue() + targetVert.getValue() <= leftVertexValue();
    }

    protected double leftVertexValue() {
        return moneyMax - currentRoute.usedVolume();
    }

    /**
     * проверяет подходит ли этот маршруи с уч>том времени на возвращение
     */
    private boolean availableRoad(RouteBlock<? extends Edge, ? extends Vertex> block) {
        double currentEdgesValue = currentRoute.getEdgesValue();

        double targetRoadDistance;
        if (currentRoute.blocks.size() <= 1) {
            targetRoadDistance = block.getDistanceWithTraffic();
        } else {
            targetRoadDistance = block.getDistanceWithHigherTraffic();
        }
        double finalRoadDistance = block.getFinalBlock().getDistanceWithHigherTraffic();
        return currentEdgesValue + targetRoadDistance + finalRoadDistance <= leftEdgeValue();
    }

    protected double leftEdgeValue() {
        // TODO: 21/10/2019
        return timeMax;
    }


    public int length() {
        return currentRoute.blocks.size();
    }
}
