public class algoGraph{
    private int vertexCount = 0;
    private Set<Vertex> vertices;
    private Set<Edge> edges;
    private Map<Vertex, Set<Edge>> adjList;
    // Hashsets and hashmaps will allow for speedier access
    // gotta go fest *insert sanic meme*

    public algoGraph{
        vertices = new HashSet<>();
        edges = new HashSet<>();
        adjList = new HashMap<>();
    }

    //more methods coming soon^tm
    public boolean addVertex(Vertex v){
        vertexCount++;
        return vertices.add(v);
    }

    public boolean removeVertex(Vertex v){
        vertexCount--;
        return vertices.remove(v);
    }

    public boolean addEdge(Edge e){
         // first check if edge can be added
        if (!edges.add(e)) return false;

        // If the source and destination nodes are not present
        // Add them to the adjacency list
        adjList.putIfAbsent(e.getSource(), new HashSet<>());
        adjList.putIfAbsent(e.getDest(), new HashSet<>());

        // Then add the edge
        adjList.get(e.getSource()).add(e);
        adjList.get(e.getDest()).add(e);

        return true;
    }

    public boolean removeEdge(Edge e){
        // first check if edge can be removed
        if(!edges.remove(e)) return false;

        // Make a set of the edges for the source and destination nodes assigned to 'e'
        Set<Edge> edgesOfSource = adjList.get(e.getSource());
        Set<Edge> edgesOfDest = adjList.get(e.getDest());

        // As long as those are not null, add the new edge
        if(edgesOfSource != null) edgesOfSource.remove(e);
        if(edgesOfDest != null) edgesOfDest.remove(e);

        return true;
    }

    public Set<Vertex> getAdjVertices(Vertex v){
        return adjList.get(v).stream().map(e -> e.getSource().equals(v) ? e.getDest() : e.getSource())
                .collect(Collectors.toSet());
    }

    public Set<Vertex> getVertices(){
        return vertices;
    }

    public Set<Edge> getEdges(){
        return edges;
    }

    public Map<Vertex, Set<Edge>> getAdjList(){
        return adjList;
    }
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
    // ACCESSOR BOIS ฅ^•ﻌ•^ฅ
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
        //multiplying by 19 (or just any number, 2019 is when we're free though :') ) should ensure unique hashcodes
        result = 19 * result + dest.hashCode();
        result = 19 * result + weight;
        return result;
    }

    // ===========================================================================
    // ACCESSOR BOIS ฅ^•ﻌ•^ฅ
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