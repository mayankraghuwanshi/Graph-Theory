import utils.*;
import java.util.*;
//connected component in graph
class main{
    public static void main(String args[]){
        Graph g = new Graph(7);
        ArrayList<Edge> graph[] = g.graph;
        g.addEdge(1,3,2,true);
        g.addEdge(1,2,10,true);
        g.addEdge(2,4,13,true);
        g.addEdge(3,4,12,true);
        g.addEdge(3,5,15,true);
        g.addEdge(5,6,16,true);
        g.addEdge(5,7,17,true);
        g.addEdge(6,7,19,true);
        g.display();
        //using bfs.  this can also be done using dfs.
        Queue<Integer> queue = new LinkedList<>();
        boolean isVisited[] = new boolean[graph.length];
        int count=0;
        for(int i=0;i<graph.length;i++){
            if(!isVisited[i]){
                queue.add(i);
                count++;
            }
            while(queue.size()>0){
                int currentVertex = queue.remove();
                isVisited[currentVertex]=true;
                for(Edge e : graph[currentVertex]){
                    if(!isVisited[e.vertex]) queue.add(e.vertex);
                }
            }
        }
        System.out.println(count);
    }
}