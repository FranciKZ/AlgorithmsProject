import java.util.*;

public class PathFinder{
    public PathFinder(){

    }
    // returns a list of vertices which is the path to follow
    // i.e. (List = {A, B, C, D} meaning the path is A -> B -> C -> D)
    public List<Vertex> findPath(algoGraph g, Vertex start, double dist){
        List<Vertex> path = new ArrayList<>();
        List<Vertex> altPath = new ArrayList<>();
        Edge e = null;
        Vertex curVert = start;
        double curDist = 0; 
        double altDist = 0;
        
        for(int i = 0; i < 25; i++){
            altPath.clear();
            altPath.add(curVert);
            while(curDist <= (dist + 0.25)){
                e = routeToTake(g.getAdjList().get(curVert));
                if(altDist + e.getWeight() <= (dist + 0.25)){
                    curVert = e.getDest();
                    altPath.add(curVert);
                    altDist += e.getWeight();
                                           
                    if(altDist >= (dist - 0.25) && altDist <= (dist + 0.25)){
                        if(Math.abs(dist - altDist) < Math.abs(dist - curDist)){
                            path = altPath;
                            curDist = altDist;
                        }
                    } 
                }
                else
                    continue;
            }
        }
        return path;
    }

    // modified binary sort thing
    // takes in a set of the edges that it will split to decide which edge to take.
    public Edge routeToTake(List<Edge> e){
        List<Edge> edges = e;
        int mid = -1;
        int low = 0;
        int high = edges.size() - 1;
        Random rand = new Random();

        if(edges.size() == 1){
            return edges.get(0);
        }

        else if (edges.size() != 0){
            while(low <= high){
                int n = rand.nextInt(51);
                mid = low + (high - low) / 2;
                if(n >= 25)
                    high = mid - 1;                                  
                else
                    low = mid + 1;
            }
            return edges.get(mid);
        }  
        else
            return null;        
    }
}