import utils.*;
import java.util.*;
class main{
    static int WHITE = -1;
    static int GREEN = 0;
    static int RED = 1;
    static boolean isBipartite(int src , ArrayList<Edge> graph[]){
        int noOfVertices = graph.length; 
        int map[] = new int[noOfVertices];
        Arrays.fill(map,WHITE);
        for(int i=0;i<noOfVertices;i++){
            if(map[i]==WHITE){
                if(!isBipartite(i,graph,map)) return false;
            }
        }
        return true;
    }
    static boolean isBipartite(int src , ArrayList<Edge> graph[],int map[]){
        map[src]=RED;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        int level = 0;
        while(queue.size()>0){
            int size = queue.size();
            int color = level%2;
            while(size-->0){
                int currentVertex = queue.remove();
                for(Edge e : graph[currentVertex]){
                    int neighbour = e.vertex;
                    if(map[neighbour]==WHITE){
                        queue.add(neighbour);
                        map[neighbour]=color;
                    }else if(map[neighbour]!=color){
                        return false;
                    }
                }
            }
            level++;
        }
        return true;
    }
    public static void main(String args[]){
        Graph g = new Graph(10);
        ArrayList<Edge> graph []= g.graph;
        g.addEdge(0,1,0,true);
        g.addEdge(1,2,0,true);
        g.addEdge(2,3,0,true);
        g.addEdge(3,4,0,true);
        g.addEdge(4,5,0,true);
        g.addEdge(5,0,0,true);
        // g.addEdge(0,4,0,true);

        g.addEdge(7,8,0,true);
        g.addEdge(8,9,0,true);
        g.addEdge(9,7,0,true);
        
        System.out.println(isBipartite(0,graph));
    }
}