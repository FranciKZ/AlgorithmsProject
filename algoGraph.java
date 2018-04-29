import java.util.stream.Collectors;
import java.util.*;

public class AlgoGraph{
    private int vertexCount = 0;
    private List<Vertex> vertices;
    private List<Edge> edges;
    private Map<Vertex, List<Edge>> adjList;

    public AlgoGraph(){
        // hashmap will allow for speedier access
        // gotta go fest *insert sanic meme*
        vertices = new ArrayList<Vertex>();
        edges = new ArrayList<Edge>();
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
        adjList.putIfAbsent(e.getSource(), new ArrayList<>());
        adjList.putIfAbsent(e.getDest(), new ArrayList<>());

        // Then add the edge
        adjList.get(e.getSource()).add(e);
        // Commenting this out seems to solve the problem
        //adjList.get(e.getDest()).add(e);

        return true;
    }

    public boolean removeEdge(Edge e){
        // first check if edge can be removed
        if(!edges.remove(e)) return false;

        // Make a set of the edges for the source and destination nodes associated with 'e'
        List<Edge> edgesOfSource = adjList.get(e.getSource());
        List<Edge> edgesOfDest = adjList.get(e.getDest());

        // As long as those are not null, remove the edge
        if(edgesOfSource != null) edgesOfSource.remove(e);
        if(edgesOfDest != null) edgesOfDest.remove(e);

        return true;
    }

    public List<Vertex> getAdjVertices(Vertex v){
        return adjList.get(v).stream().map(e -> e.getSource().equals(v) ? e.getDest() : e.getSource())
                .collect(Collectors.toList());
    }

    public int checkCount(Vertex v){
        int result = 0;
        
        for(Edge e : adjList.get(v)){
            if(e.isChecked)
                result++
        }
        return result;
    }

    public List<Vertex> getVertices(){
        return vertices;
    }

    public List<Edge> getEdges(){
        return edges;
    }

    public Map<Vertex, List<Edge>> getAdjList(){
        return adjList;
    }
}

class Vertex{
    private int label;

    public Vertex(int label){
        setLabel(label);
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(!(obj instanceof Vertex)) return false;

        Vertex obj1 = (Vertex) obj;
        return obj1.label == label;
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

class Edge{
    private Vertex source;
    private String label;
    private Vertex dest;
    private double weight;
    private boolean checked;
    private static final double DEFAULT_WEIGHT = 1;
    private static final boolean DEFAULT_CHECKED = false;

    public Edge(String label, Vertex source, Vertex dest){
        this(label, source, dest, DEFAULT_WEIGHT, DEFAULT_CHECKED);
    }

    public Edge(String label, Vertex source, Vertex dest, double weight){
        this(label, source, dest, weight, DEFAULT_CHECKED);
    }

    public Edge(String label, Vertex source, Vertex dest, double weight, boolean checked){
        setLabel(label);
        setSource(source);
        setDest(dest);
        setWeight(weight);
        setChecked(checked);
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if (!(obj instanceof Edge)) return false;

        Edge e = (Edge) obj;
        return e.source.equals(source) && e.dest.equals(dest)
                && e.weight == weight && e.checked == checked;
    }

    @Override
    public int hashCode(){
        int result = source.hashCode();
        //multiplying by 19 (or just any number, 2019 is when we're free though :') ) should ensure unique hashcodes
        result = 19 * result + dest.hashCode();
        result = (int)(19 * result + weight);
        return result;
    }

    // ===========================================================================
    // ACCESSOR BOIS ฅ^•ﻌ•^ฅ
    // ===========================================================================
    private void setSource(Vertex s){
        this.source = s;
    }

    private void setLabel(String s){
        this.label = s;
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

    public String getLabel(){
        return label;
    }

    public double getWeight(){
        return weight;
    }

    public boolean isChecked(){
        return checked;
    }
}