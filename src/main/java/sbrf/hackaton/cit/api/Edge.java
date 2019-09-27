package sbrf.hackaton.cit.api;

import java.util.Objects;

/**
 * Created by Komyshenets on 25.09.2019.
 */
public abstract class Edge {
    private Vertex[] nodes = new Vertex[2];

    public void addVertex(Vertex left, Vertex right) {
        left.addEdge(this);
        nodes[0] = left;
        right.addEdge(this);
        nodes[1] = right;
    }

    public Vertex getLeft() {
        return nodes[0];
    }

    public Vertex getRight() {
        return nodes[1];
    }

    public Vertex getTarget(Vertex from) {
        if (!Objects.equals(from, getLeft())) return getLeft();
        if (!Objects.equals(from, getRight())) return getRight();
        return null;
    }

    public abstract Object getValue();
}

