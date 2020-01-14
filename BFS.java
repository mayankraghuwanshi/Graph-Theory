import java.util.*;
import utils.Graph;
import utils.Edge;
class main{

    //using queue.
    static void BFS(ArrayList<Edge> graph[] , int src){
        boolean isVisited[] = new boolean[graph.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        StringBuilder output = new StringBuilder();
        isVisited[src]=true;
        while(queue.size()>0){
            int enquedVertex = queue.peek();
            queue.remove();
            output.append(enquedVertex+"->");
            for(Edge e : graph[enquedVertex]){
                int currentVertex = e.vertex;
                if(!isVisited[currentVertex]){
                    isVisited[currentVertex]=true;
                    queue.add(currentVertex);
                }
            }
        }
        System.out.println(output.substring(0,output.length()-2));
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
        BFS(graph,1);
               
    }
}