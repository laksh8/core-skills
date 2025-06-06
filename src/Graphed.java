import java.util.HashMap;
import java.util.Map;

public class Graphed {

    private Map<String, Map<String, Integer>> adjacencyList;

    Graphed(){

        adjacencyList = new HashMap<>();

    }

    public void addEdge(String source, String destination, int cost){

        Map<String, Integer> edges = adjacencyList.get(source);

        if (edges == null){

            edges = new HashMap<>();
            edges.put(destination, cost);

            adjacencyList.put(source, edges);

            return;

        }

        edges.put(destination, cost);

    }

    public boolean removeEdge(String source, String destination) {

        Map<String, Integer> edges = adjacencyList.get(source);

        if (edges == null) return false;
        if (edges.get(destination) == null) return false;

        edges.remove(destination);

        return true;

    }

    public int getWeight(String source, String destination){

        Map<String, Integer> edges = adjacencyList.get(source);

        if (edges == null) return -1;
        if (edges.get(destination) == null) return -1;

        return edges.get(destination);

    }

    public void printGraph() {

        for (Map.Entry<String, Map<String, Integer>> entry : adjacencyList.entrySet()) {

            String source = entry.getKey();
            Map<String, Integer> edges = entry.getValue();

            for (Map.Entry<String, Integer> edge : edges.entrySet()) {

                String destination = edge.getKey();
                int cost = edge.getValue();

                System.out.println(source + " -> " + destination + " [cost: " + cost + "]");

            }

        }

    }


}
