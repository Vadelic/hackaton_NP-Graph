package sbrf.hackaton.cit.api;

public interface Cursor<E extends Edge, V extends Vertex> {
    /**
     * Создает объект состояния в момент вызова
     */
    Route fixRoute();

    /**
     * Вызывается при перемещении к точке
     */
    void goToPoint(E road, V point);

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
     */
    boolean availableRoot(E targetRoad, V targetPoint);


}
