package sbrf.hackaton.cit.api;

public interface Route {
    /**
     * Стоимость данного маршрута
     */
    default double getCost() {
        double atmValue = getAtmValue();
        double roadValue = getRoadValue();
        return atmValue / roadValue;
    }

    /**
     * Получить общий вес ребер на маршруте
     */
    double getRoadValue();

    /**
     * Получить общий вес вершин на маршруте
     */
    double getAtmValue();
}
