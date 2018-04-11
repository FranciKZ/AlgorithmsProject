public class algoGraph{
    private int nodeCount = 0;

    // Use a doubly-linked list (or singly linked list and just save the previous node in a variable, idc.) 
    // to store the nodes, each node has the list of edges
    public algoGraph(){

    }
}

public class Node{
    private String label;
    private List<Edge> edges;

    public Node(String label){
        setLabel(label);
    }

    public void addEdge(Edge e){
        edges.add(e);
    }
    public void setLabel(String s){
        label = s;
    }
}

public class Edge{
    private Node source;
    private Node dest;
    private double weight;

    public Edge(Node source, Node dest, double weight){
        this.source = source;
        this.dest = dest;
        this.weight = weight;
    }
}