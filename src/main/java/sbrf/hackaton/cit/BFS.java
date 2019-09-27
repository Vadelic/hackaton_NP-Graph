package sbrf.hackaton.cit;

import sbrf.hackaton.cit.api.Vertex;

import java.util.Map;
import java.util.concurrent.LinkedBlockingDeque;

public class BFS {
    public void search(Vertex vertex) {
        LinkedBlockingDeque<Vertex> vertexQueue = new LinkedBlockingDeque<>();
        vertexQueue.add(vertex);
        while (!vertexQueue.isEmpty()) {
            Vertex nodeCurrent = vertexQueue.poll();
            nodeCurrent.visit();
            System.out.println(nodeCurrent);


            Map<Vertex, Object> targetNodes = nodeCurrent.getTargetNodes();
            for (Map.Entry<Vertex, Object> entry : targetNodes.entrySet()) {
                Vertex key = entry.getKey();
                if (!key.isVisited()) {
                    key.visit();
                    vertexQueue.addLast(key);
                }
            }
        }
    }

    public void weight(Vertex vertex) {
        LinkedBlockingDeque<Vertex> vertexQueue = new LinkedBlockingDeque<>();
        vertexQueue.add(vertex);
        while (!vertexQueue.isEmpty()) {
            Vertex nodeCurrent = vertexQueue.poll();
            nodeCurrent.visit();
            System.out.println(nodeCurrent + "->V:" + nodeCurrent.marker());

            Map<Vertex, Object> targetNodes = nodeCurrent.getTargetNodes();
            for (Map.Entry<Vertex, Object> entry : targetNodes.entrySet()) {
                Vertex key = entry.getKey();
                if (!key.isVisited()) {
                    key.visit();
                    vertexQueue.addLast(key);
                }
            }
        }
    }
}
