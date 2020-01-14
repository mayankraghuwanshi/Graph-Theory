import java.util.*;
import utils.Graph;
import utils.Edge;
class main{
    //NOTE: BFS can't detect cycle in a directed graph.
    //Below implementation is can only work with undirected graph.
    static void BFS(int src , int des, ArrayList<Edge> graph[] ){
        boolean isVisited [] = new boolean[graph.length];
        Queue<Integer> queue = new LinkedList<>();
        int cycle=0;
        int level=0;
        queue.add(src);
        queue.add(-1);
        while(queue.size()>1){
            int currentVertex = queue.remove();
            if(currentVertex==-1){
                queue.add(-1);
                level++;
                continue;
            }
            if(isVisited[currentVertex]){
                cycle++;
                System.out.println("Cycle detected @ "+currentVertex);
                continue;
            }
            if(currentVertex==des){
                System.out.println("Vertex "+des+" has found at level "+level+ " from "+src);
            }
            isVisited[currentVertex]=true;
            for(Edge e : graph[currentVertex]){
                queue.add(e.vertex);
            }
        }
    }
    static void BFS2(int src , int des , ArrayList<Edge> graph[]){
        boolean isVisited[] = new boolean[graph.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        int level=0;
        int cycle=0;
        while(queue.size()>0){
            int size = queue.size();
            while(size-->0){
                int currentVertex = queue.remove();
                if(isVisited[currentVertex]){
                    cycle++;
                    System.out.println("Cycle detected @ "+currentVertex);
                    continue;
                }
                isVisited[currentVertex]=true;
                if(currentVertex==des){
                    System.out.println("Vertex "+des+" has found at level "+level+ " from "+src);
                }
                for(Edge e : graph[currentVertex]){
                    queue.add(e.vertex);
                }
            }
            level++;
        }
    }
    public static void main(String args[]){
        Graph g = new Graph(5);
        ArrayList<Edge> graph[] = g.graph;
        g.addEdge(0,3,2,false);
        g.addEdge(0,1,10,false);
        g.addEdge(1,2,13,false);
        g.addEdge(3,4,12,false);
        g.addEdge(4,2,15,false);
        // g.addEdge(5,6,16,true);
        // g.addEdge(5,7,17,true);
        // g.addEdge(6,7,19,true);
        // BFS(1,6,graph);
        BFS2(0,4,graph);
               
    }
}