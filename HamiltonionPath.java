import utils.*;
import java.util.*;
class main{
    static int hamiltonianPath(int src , ArrayList<Edge> graph[] , boolean visited[] , int count , String res){
        res=res+"->"+src;
        if(count==graph.length-1){
            System.out.println(res);
            return 1;
        }
        visited[src]=true;
        int count_=0;
        for(Edge e : graph[src]){
            int neighbour = e.vertex;
            if(!visited[neighbour]){
                count+=hamiltonianPath(neighbour,graph,visited,count+1,res);
            }
        }
        visited[src]=false;
        return count_;
    }
    
    public static void main(String args[]){
        Graph g = new Graph(4);
        ArrayList<Edge> graph []= g.graph;
        g.addEdge(0,1,0,true);
        g.addEdge(1,2,0,true);
        g.addEdge(2,3,0,true);
        g.addEdge(3,0,0,true);
        g.addEdge(0,2,0,true);
        boolean visited[] = new boolean[graph.length];
        System.out.println(hamiltonianPath(0,graph,visited,0,""));
        
    }
}