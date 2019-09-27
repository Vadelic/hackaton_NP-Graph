package sbrf.hackaton.cit;

import sbrf.hackaton.cit.domain.Atm;
import sbrf.hackaton.cit.domain.Road;

import java.util.TreeMap;

/**
 * Created by Komyshenets on 25.09.2019.
 */
public class Main {

    public static void main(String[] args) {

        TreeMap<Object, Atm> vertexes = new TreeMap<>();
        for (int i = 1; i < 10; ) {
            vertexes.put(i++, new Atm(i));
        }

        Graph<Road, Atm> graph = new Graph<>(vertexes);
        graph.addEdge(1, new Road(3), 3);
        graph.addEdge(1, new Road(4), 2);
        graph.addEdge(1, new Road(1), 4);
        graph.addEdge(2, new Road(3), 3);
        graph.addEdge(2, new Road(6), 4);
        graph.addEdge(4, new Road(14), 7);
        graph.addEdge(5, new Road(11), 8);
        graph.addEdge(8, new Road(4), 6);
        graph.addEdge(6, new Road(2), 9);
        graph.addEdge(7, new Road(1), 9);
        graph.addEdge(4, new Road(8), 6);
        graph.addEdge(7, new Road(2), 6);
        graph.addEdge(8, new Road(3), 10);
        graph.addEdge(8, new Road(9), 9);
        System.out.println(graph);
    }

}
