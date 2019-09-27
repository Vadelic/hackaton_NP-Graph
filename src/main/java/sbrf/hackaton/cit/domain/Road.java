package sbrf.hackaton.cit.domain;

import sbrf.hackaton.cit.api.Edge;
import sbrf.hackaton.cit.api.Vertex;

/**
 * Created by Komyshenets on 25.09.2019.
 */
public class Road extends Edge {
    private final int distance;

    public Road(int distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return String.format("(%s)-%d-(%s)", getLeft(), distance, getRight());
    }

    @Override
    public Integer getValue() {
        return distance;
    }
}


