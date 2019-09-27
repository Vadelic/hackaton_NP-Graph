package sbrf.hackaton.cit.np;

import java.io.IOException;
import java.util.Stack;

public class Kamnevoyager {
    private static class State {
        int cityNum;
        int nextIndex;
        boolean isStartPoint;
        State prev;

        State(State prev, int city) {
            this.prev = prev;
            cityNum = city;
            isStartPoint = false;
        }

        State(State prev, int city, boolean start) {
            this.prev = prev;
            cityNum = city;
            isStartPoint = start;
        }

        int calculateLength(GraphNp graph) {
            State current = this;
            int sum = 0;

            while (current.prev != null) {
                sum += graph.getEdge(current.prev.cityNum, current.cityNum);
                current = current.prev;
            }

            return sum;
        }

        @Override
        public String toString() {
            if (prev == null) return Integer.toString(cityNum);
            else {
                return prev.toString() + " " + cityNum;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        String filename = args[0];

        GraphNp graph = GraphNp.load(filename);

        Stack<State> states = new Stack<>();

        State state = null;
        for (int i = 1; i < args.length; i++) {
            state = new State(state, Integer.parseInt(args[i]), true);
            states.push(state);
            graph.enter(state.cityNum);
        }

        State shortest = null;

        state = states.pop();

        while (!state.isStartPoint || !(state.nextIndex >= graph.getCount())) {
            int index = state.nextIndex++;

            if (index >= graph.getCount()) {
                graph.leave(state.cityNum);
                state = states.pop();
            } else if (graph.hasEdge(state.cityNum, index) && graph.enter(index)) {
                states.push(state);
                state = new State(state, index);
            }

            if (graph.allVisited()) {
                if (shortest == null) {
                    shortest = state;

                } else {
                    if (shortest.calculateLength(graph) > state.calculateLength(graph)) {
                        shortest = state;
                    }
                }
            }
        }

        System.out.println(shortest);
    }
}