package sbrf.hackaton.cit.core;

import java.util.List;

public interface Vertex {

    /**
     * Все ребра ведущие к вершинам
     */
    List<RouteBlock> getPossibleRoutes();

    RouteBlock getFinalBlock();

    /**
     * Получить вес вершины
     */
    double getValue();

}
