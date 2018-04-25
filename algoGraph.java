public class algoGraph{
    private int nodeCount = 0;
    private Set<Vertex> vertices;
    private Set<Edge> edges;
    private Map<Vertex, Set<Edge>> adjList;
    // Use a doubly-linked list (or singly linked list and just save the previous node in a variable, idc.) 
    // to store the nodes, each node has the list of edges
    // Will this work? Is it even a graph? Probably not technically, but it's literally example code so who tf cares
    public algoGraph{
        vertices = new HashSet<>();
        edges = new HashSet<>();
        adjList = new HashMap<>();
    }

    //more methods coming soon^tm


}

private class Vertex{
    private int label;

    public Node(int label){
        setLabel(label);
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(!(obj instanceof Vertex)) return false;

        Vertex _obj = (Vertex) obj;
        return _obj.label == label;
    }

    @Override
    public int hashCode(){
        return label;
    }

    // =======================================================
    // ACCESSORS BOI
    // =======================================================
    
    private void setLabel(int l){
        this.label = l;
    }

    public int getLabel(){
        return label;
    }
}

private class Edge{
    private Node source;
    private Vertex dest;
    private double weight;
    private boolean checked;
    private static final double DEFAULT_WEIGHT = 1;
    private static final boolean DEFAULT_CHECKED = false;

    public Edge(Vertex source, Node dest){
        // too lazy to make getters/setters atm so deal with this for now
        this(source, dest, DEFAULT_WEIGHT, DEFAULT_CHECKED);
    }
    public Edge(Vertex source, Vertex dest, double weight, boolean checked){
        setSource(source);
        setDest(dest);
        setWeight(weight);
        setChecked(checked);
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if (!(obj instanceof Edge)) return false;

        return _obj.source.equals(source) && _obj.dest.equals(dest)
                && _obj.weight == weight && _obj.checked == checked;
    }

    @Override
    public int hashCode(){
        int result = source.hashCode();
        //multiplying by 19 (or just any number, 2019 is when we're free :') ) ensures unique hashcodes
        result = 19 * result + dest.hashCode();
        result = 19 * result + weight;
        return result;
    }

    // ===========================================================================
    // Accessors
    // ===========================================================================
    private void setSource(Vertex s){
        this.source = s;
    }

    private void setDest(Vertex d){
        this.dest = d;
    }

    private void setWeight(double w){
        this.weight = w;
    }

    private void setChecked(boolean c){
        this.checked = c;
    }

    public Vertex getSource(){
        return source;
    }

    public Vertex getDest(){
        return dest;
    }

    public double getWeight(){
        return weight;
    }

    public boolean isChecked(){
        return checked;
    }
}