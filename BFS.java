import java.util.*;
import utils.Graph;
import utils.Edge;
class main{
    //NOTE: BFS can't detect cycle in a directed graph.
    //Below implementation is can only work with undirected graph.
    static void BFS(int src , int des , ArrayList<Edge> graph[]){
        boolean isVisited[] = new boolean[graph.length];
        Queue<Integer> queue = new LinkedList<>();
        int level = 0;
        queue.add(src);
        queue.add(-1);
        isVisited[src]=true;
        while(queue.size()>1){
            int currentVertex = queue.remove();
            if(currentVertex==-1){
                queue.add(-1);
                level++;
                continue;
            }
            if(currentVertex==des){
                    System.out.println("Vertex "+des+" has found at level "+level+" from source "+src);
            }
            for(Edge e : graph[currentVertex]){
                int neighbour = e.vertex;
                if(!isVisited[neighbour]){
                    queue.add(neighbour);
                }
            }
        }
    }
   

    static void BFS2(int src , int des , ArrayList<Edge> graph[]){
        boolean isVisited[] = new boolean[graph.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        int level=0;
        isVisited[src]=true;
        while(queue.size()>0){
            int size = queue.size();
            while(size-->0){
                int currentVertex = queue.remove();
                if(currentVertex==des){
                    System.out.println("Vertex "+des+" has found at level "+level+" from source "+src);
                }
                for(Edge e : graph[currentVertex]){
                    int neighbour = e.vertex;
                    if(!isVisited[neighbour]){
                        queue.add(neighbour);
                    }
                }
            }
            level++;
        }
    }

    static void BFS3(int src , int des , ArrayList<Edge>graph[]){
        int n = graph.length;
        int parent[] = new int[n];
        int distance[] = new int[n];
        boolean isVisited[] = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        isVisited[src]=true;
        distance[src]=0;
        parent[src]=-1;
        while(queue.size()>0){
            int currentVertex = queue.remove();
            if(currentVertex==des){
                System.out.println("Vertex "+des+" has found at level "+distance[currentVertex]+" from source "+src);
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
                int neighbour = e.vertex;
                if(!isVisited[neighbour]){
                    isVisited[neighbour]=true;
                    queue.add(neighbour);
                    parent[neighbour]=currentVertex;
                    distance[neighbour]=distance[currentVertex]+1;
                }
            }
        }
    }

    public static void main(String args[]){
        Graph g = new Graph(6);
        ArrayList<Edge> graph[] = g.graph;
        g.addEdge(0,4,2,false);
        g.addEdge(0,1,10,false);
        g.addEdge(1,2,13,false);
        g.addEdge(2,4,12,false);
        g.addEdge(2,3,15,false);
        g.addEdge(3,5,15,false);
        g.addEdge(4,3,15,false);
        // g.display();
        // BFS(0,4,graph);
        // BFS2(0,4,graph);
        BFS3(0,3,graph);

               
    }
}