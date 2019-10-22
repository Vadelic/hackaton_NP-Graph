package sbrf.hackaton.cit.core;

import java.util.List;

public interface Vertex {

    /**
     * Все ребра ведущие к вершинам
     */
    List<RouteBlock> getPossibleRoutes();

    RouteBlock getFinalRoute();

    /**
     * Получить вес вершины
     */
    double getValue();

}
