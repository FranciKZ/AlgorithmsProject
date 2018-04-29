import java.util.*;
class Main{
    // main class to build the gui and such in
    public static void main(String[] args){
        AlgoGraph g = new AlgoGraph();
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Vertex v4 = new Vertex(4);
        Vertex v5 = new Vertex(5);

        Edge e1 = new Edge("e1", v1, v2);
        Edge e2 = new Edge("e2", v3, v4);
        Edge e3 = new Edge("e3", v2, v4);
        Edge e4 = new Edge("e4", v1, v5);

        g.addEdge(e1);
        g.addEdge(e2);
        g.addEdge(e3);
        g.addEdge(e4);
        // Testing purposes

        PathFinder p = new PathFinder();
        // Something is wrong with routeToTake. Or the data structure. Hopefully it's routeToTake.
        // Not anymore motherfucker.

        for (Edge e : g.getAdjList().get(e1.getSource())){
            System.out.println(e.getLabel());
        }

        //Vertex v = p.routeToTake(g.getAdjList().get(e1.getSource()));
        //System.out.println(v.getLabel());
    }
}