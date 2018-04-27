import java.util.*;
class Main{
    // main class to build the gui and such in
    public static void main(String[] args){
        AlgoGraph g = new AlgoGraph();
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Vertex v4 = new Vertex(4);

        Edge e1 = new Edge(v1, v2);
        Edge e2 = new Edge(v3, v4);
        Edge e3 = new Edge(v2, v4);

        g.addEdge(e1);
        g.addEdge(e2);
        g.addEdge(e3);

        // Testing purposes

        PathFinder p = new PathFinder();
        // Something is wrong with routeToTake. Or the data structure. Hopefully it's routeToTake.
        //System.out.println(e3.getSource().getLabel());
        //System.out.println(g.getAdjList().get(e3.getSource()).size());

        for (Edge e : g.getAdjList().get(e3.getSource())){
            System.out.println(e.getSource().getLabel());
            System.out.println(e.getDest().getLabel());
        }
    
        //System.out.println(g.getAdjList().get(e3.getSource()));
        
        //Vertex v = p.routeToTake(g.getAdjList().get(e1.getSource()));
        //System.out.println(v.getLabel());
    }
}