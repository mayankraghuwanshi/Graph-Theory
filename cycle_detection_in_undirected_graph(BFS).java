import utils.*;
import java.util.*;
class main{
       
    //below BFS method also called coloring method.
    //if we come to a vertex which is grey (0, which means this vertex is still inside the queue) then there is a cycle.
    static boolean hasCycleBFS(int src , ArrayList<Edge> graph[]){
        int color[] = new int[graph.length];
        Arrays.fill(color,-1);
        //(-1:white)-> yet to be visited.
        //( 0:grey)-> inside the queue.
        //( 1:black)-> visited.
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        color[src]=0;
        while(queue.size()>0){
            System.out.println(queue);
            int currentVertex = queue.remove();
            color[currentVertex]=1;
            for(Edge e : graph[currentVertex]){
                int neighbourVertex = e.vertex;
                if(color[neighbourVertex]==0){
                    return true;
                }else if(color[neighbourVertex]==-1){
                    color[neighbourVertex]=0;
                    queue.add(neighbourVertex);
                }
            }
        }
        return false;
    }
    

    public static void main(String args[]){
        Graph g = new Graph(14);
        ArrayList<Edge> graph[] = g.graph;
        // g.addEdge(0,1,0,true);
        // g.addEdge(1,2,0,true);
        // g.addEdge(2,3,0,true);
        // g.addEdge(3,4,0,true);
        // g.addEdge(4,6,0,true);
        // g.addEdge(3,5,0,true);
        // g.addEdge(5,6,0,true);
        // g.addEdge(5,9,0,true);
        // g.addEdge(6,10,0,true);
        // g.addEdge(10,11,0,true);
        // g.addEdge(11,12,0,true);
        // g.addEdge(11,13,0,true);
        // g.addEdge(13,12,0,true);
        // g.addEdge(4,7,0,true);
        // g.addEdge(7,8,0,true);
        g.addEdge(0,1,0,true);
        g.addEdge(1,2,0,true);
        g.addEdge(2,3,0,true);
        g.addEdge(3,0,0,true);
        
        g.display();
        System.out.println(hasCycleBFS(0,graph));       
    }
}