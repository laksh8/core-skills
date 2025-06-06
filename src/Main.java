public class Main {
    public static void main(String[] args) {

        // trying out graph

        Graphed gp = new Graphed();

        gp.addEdge("A", "B", 32);
        gp.addEdge("A", "C", 3);
        gp.addEdge("C", "B", 2);
        gp.addEdge("D", "B", 332);
        gp.addEdge("E", "B", 12);
        gp.addEdge("A", "D", 456);
        gp.addEdge("A", "E", 44);
        gp.addEdge("B", "A", 35);
        gp.addEdge("D", "A", 36);
        gp.addEdge("C", "A", 31);

        gp.printGraph();

        gp.removeEdge("A", "B");

        System.out.println("\n " + gp.getWeight("A", "E") + "\n");

        gp.printGraph();

    }

}