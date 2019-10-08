package sbrf.hackaton.cit.api;

import java.util.Map;

public interface Vertex {

    /**
     * Все ребра ведущие к вершинам
     */
    Map<? extends Edge, ? extends Vertex> getPossibleRoutes();

}
