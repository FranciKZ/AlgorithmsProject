public class algoGraph{
    private int nodeCount = 0;

    // Use a doubly-linked list (or singly linked list and just save the previous node in a variable, idc.) 
    // to store the nodes, each node has the list of edges
    // Will this work? Is it even a graph? Probably not technically, but it's literally example code so who tf cares
    public algoGraph(){

    }
}

class Node{
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

class Edge{
    private Node source;
    private Node dest;
    private double weight;
    private boolean checked;

    public Edge(Node source, Node dest, double weight, boolean checked){
        // too lazy to make getters/setters atm so deal with this for now
        this.source = source;
        this.dest = dest;
        this.weight = weight;
        this.checked = checked;
    }
}