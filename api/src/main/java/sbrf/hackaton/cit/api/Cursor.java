package sbrf.hackaton.cit.api;

public interface Cursor {
    /**
     * Создает объект состояния в момент вызова
     */
    Route fixRoute();

    /**
     * Вызывается при перемещении к точке
     * @param road
     * @param point
     */
    void goToPoint(Edge road, Vertex point);

    /**
     * Вызывается когда смещается на предыдущую позицию
     */

    void removePointAndRoad();

    /**
     * Проверка неявляется ли это первая точка в маршруте
     */
    boolean justStarted();


    /**
     * проверка может ли объект сместиться к указаной точке
     * @param targetRoad
     * @param targetPoint
     */
    boolean availableRoot(Edge targetRoad, Vertex targetPoint);


}
