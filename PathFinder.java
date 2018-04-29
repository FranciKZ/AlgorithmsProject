import java.util.*;

public class PathFinder{
    // soon to be a beautiful path finding program that everyone will adore
    public PathFinder(){

    }
    // returns a list of vertices which is the path to follow
    // i.e. (List = {A, B, C, D} meaning the path is A -> B -> C -> D)
    public List<Vertex> findPath(algoGraph g, Vertex start, double dist){
        List<Vertex> path = new ArrayList<>();
        Edge e = null;
        Vertex curVert = start;
        Edge lastEdgeTaken = null;
        double curDist = 0;
        int checkCount = 0;
        path.add(curVert);

        while(curDist <= (dist + 0.25)){
            e = routeToTake(g.getAdjList().get(curVert));
            if(e == null){
                continue;
            }
            else if(curDist + e.getWeight() <= (dist + 0.25)){
                curVert = e.getDest();
                path.add(curVert);
                curDist += e.getWeight(); 
                lastEdgeTaken = e;
                                                
                if(curDist >= (dist - 0.25) && curDist <= (dist + 0.25)){
                    return path;
                } 
            }
            else
                return findPath(g, start, dist);
        }
        return null;
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
                        // generate the random each time. Will probably change this up but is here to make sure we know to do it 
                        // on every loop
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