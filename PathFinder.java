import java.util.*;

public class PathFinder{
    // soon to be a beautiful path finding program that everyone will adore
    public PathFinder(){

    }
    // returns a list of vertices which is the path to follow
    // i.e. (List = {A, B, C, D} meaning the path is A -> B -> C -> D)
    public List<Vertex> findPath(AlgoGraph g, Vertex start, double dist){
        return null;
    }

    // modified binary sort thing
    // takes in a set of the edges that it will split to decide which edge to take.
    public Vertex routeToTake(List<Edge> e){
        List<Edge> edges = e;
        int mid = -1;
        int low = 0;
        int high = edges.size() - 1;
        Random rand = new Random();

        if(edges.size() == 1)
            return edges.get(0).getDest();

        if(edges.size() == 0)
            return null;

        else{
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
            return edges.get(mid).getDest();
        }
    }
}