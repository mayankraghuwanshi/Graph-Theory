import utils.*;
import java.util.*;
class main{
    static void DFS(ArrayList<Edge> graph[] , int src){
        Stack<Integer> stack = new Stack<>();

    }
    public static void main(String args[]){
        Graph g = new Graph(8);
        ArrayList<Edge> graph[] = g.graph;
        g.addEdge(1,3,2,true);
        g.addEdge(1,2,10,true);
        g.addEdge(2,4,13,true);
        g.addEdge(3,4,12,true);
        g.addEdge(3,5,15,true);
        g.addEdge(5,6,16,true);
        g.addEdge(5,7,17,true);
        g.addEdge(6,7,19,true);

    }
}
