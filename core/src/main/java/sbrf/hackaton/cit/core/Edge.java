package sbrf.hackaton.cit.core;


public interface Edge {
    /**
     * Получить вес ребра
     */
    double getDistance();

    double getDistanceWithTraffic();

    double getDistanceWithHigherTraffic();
}
