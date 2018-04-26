import java.util.*;

public class PathFinder{
    // soon to be a beautiful path finding program that everyone will adore

    // returns a list of vertices which is the path to follow
    // i.e. (List = {A, B, C, D} meaning the path is A -> B -> C -> D)
    public List<Vertex> findPath(algoGraph g, Vertex start, double dist){

    }

    // modified binary sort thing
    // takes in a set of the edges that it will split to decide which edge to take.
    private Vertex routeToTake(Set<Edge> e){
        Set<Edge> edges = e;
        Random rand = new Random();
        for(int i = 0; i < edges.size(); i++){
            // generate the random each time. Will probably change this up but is here to make sure we know to do it 
            // on every loop
            int n = rand.nextInt(51);
        }
        // placeholder return for error purposes
        return null;
    }
}