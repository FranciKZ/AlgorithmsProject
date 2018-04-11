public class algoGraph{
    
    public class Node{
        private String label;
        private List<Edge> edges;
    
        public void addEdge(Edge e){
            edges.add(e);
        }
        public void setLabel(String s){
            label = s;
        }
    }
    
    public class Edge{
        private Node destination;
        private double weight;
    
    }



}

