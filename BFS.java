import java.util.*;
import utils.Graph;
import utils.Edge;
class main{

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
        // BFS(1,6,graph);
        BFS2(1,6,graph);
               
    }
}