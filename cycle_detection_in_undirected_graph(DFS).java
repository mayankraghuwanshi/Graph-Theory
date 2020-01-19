import utils.*;
import java.util.*;
class main{
    //to detect cycle in a undirected graph we will use DFS and we try to visit a vertex
    //which is alredy visited and not parent of current 
    //vertex then there is a cycle.
    static boolean hasCycleDFS(int src , ArrayList<Edge> graph[]){
        int noOfNodes=graph.length;
        boolean isVisited[] = new boolean[noOfNodes];
        int parent[] = new int[noOfNodes];
        Stack<Integer> stack = new Stack<>();
        stack.push(src);
        isVisited[src]=true;
        parent[src]=-1;
        boolean cycle=false;
        while(stack.size()>0){
            int currentVertex = stack.pop();
            for(Edge e : graph[currentVertex]){
                int neighbourVertex = e.vertex;
                if(!isVisited[neighbourVertex]){
                    isVisited[neighbourVertex]=true;
                    parent[neighbourVertex]=currentVertex;
                    stack.push(neighbourVertex);
                }
                else if(isVisited[neighbourVertex] && parent[currentVertex]!=neighbourVertex){
                    return true;
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
        System.out.println(hasCycleDFS(0,graph));
        
        
        
    }
}