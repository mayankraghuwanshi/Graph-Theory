import utils.*;
import java.util.*;
class main{
    public static void main(String args[]){
        Graph g = new Graph(6);
        ArrayList<Edge> graph [] = g.graph;
        g.addEdge(0,4,2,false);
        g.addEdge(0,1,10,false);
        g.addEdge(1,2,13,false);
        g.addEdge(2,4,12,false);
        g.addEdge(2,3,15,false);
        g.addEdge(3,5,15,false);
        g.addEdge(4,3,15,false);
        BFS(0,4,graph);
    }

    static int WHITE = 0;
    static int GREY = 0;
    static int BLACK = 2;
    static void BFS (int src, int des ,ArrayList<Edge> graph[]){
        int noOfVertices = graph.length;
        int color[] = new int[noOfVertices];
        int distance[] = new int[noOfVertices];
        int parent[] = new int[noOfVertices];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        parent[src]=-1;
        distance[src]=0;
        color[src]=GREY;
        while(queue.size()>0){
            int currentVertex = queue.remove();
            if(currentVertex==des){
                System.out.println("Vertex has found at distance "+distance[currentVertex]+" from vertex "+src);
                int tempVertex = currentVertex;
                int tempParent = parent[currentVertex];
                while(tempParent!=-1){
                    System.out.print(tempVertex+"<-");
                    tempVertex=tempParent;
                    tempParent=parent[tempParent];
                }
                System.out.println(tempVertex);        
            }
            for(Edge e : graph[currentVertex]){
                int neighbourVertex = e.vertex;
                if(color[neighbourVertex]==WHITE){
                    color[neighbourVertex]=GREY;
                    parent[neighbourVertex]=currentVertex;
                    distance[neighbourVertex]=distance[currentVertex]+1;
                    queue.add(neighbourVertex);
                }
            }
        }
    }
}