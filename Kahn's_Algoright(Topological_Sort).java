import java.util.*;
import utils.*;
class main{
    public static void main(String args[]){
        Graph g = new Graph(6);
        ArrayList<Edge> graph[] = g.graph;
        g.addEdge(5,0,0,false);
        g.addEdge(5,2,0,false);
        g.addEdge(4,0,0,false);
        g.addEdge(4,1,0,false);
        g.addEdge(2,3,0,false);
        g.addEdge(3,1,0,false);
        g.addEdge(1,2,0,false);
        // g.addEdge(0,5,0,false);
        // g.addEdge(0,5,0,false);
        System.out.println(topologicalSort(graph));
        
    }
    static LinkedList<Integer> topologicalSort(ArrayList<Edge> graph[]){
        int noOfVertices = graph.length;
        int degree[] = new int[noOfVertices];
        for(int i=0;i<noOfVertices;i++){
            for(Edge e : graph[i]){
                degree[e.vertex]++;
            }
        }
        LinkedList<Integer> res = new LinkedList<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<noOfVertices;i++){
            if(degree[i]==0) queue.add(i);
        }
        int noOfPopedVertex=0;
        if(queue.size()==0) return new LinkedList<>();

        while(queue.size()>0){
            int currentVertex = queue.remove();
            noOfPopedVertex++;
            res.addLast(currentVertex);
            for(Edge e : graph[currentVertex]){
                int neighbourVertex = e.vertex;
                if(0==(--degree[neighbourVertex])){
                    queue.add(neighbourVertex);
                }
            }
        }
        if(noOfPopedVertex==noOfVertices) return res;
        System.out.println("Cycle detected!");
        return new LinkedList<>();
    }
}