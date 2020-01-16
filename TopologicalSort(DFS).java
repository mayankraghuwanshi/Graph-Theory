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
        // g.display();
        System.out.println(topologicalSort(graph));
        
    }
    static LinkedList<Integer> topologicalSort(ArrayList<Edge> graph[]){
        int noOfVertex = graph.length;
        boolean isVisited[] = new boolean[noOfVertex];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<noOfVertex;i++){
            boolean taken[] = new boolean[noOfVertex];
            if(!isVisited[i]){
                if(DFS(i,graph,isVisited,stack,taken)){
                    System.out.println("Cycle detected!");
                    return new LinkedList<>();
                }
            }
        }
        LinkedList<Integer> res = new LinkedList<>();
        while(stack.size()>0){
            res.addLast(stack.pop());
        }
        return res;
    }
    static boolean DFS(int src ,ArrayList<Edge> graph[], boolean isVisited[] , Stack<Integer> stack,boolean []taken){
        isVisited[src]=true;
        taken[src]=true;
        for(Edge e : graph[src]){
            int neighbourVertex = e.vertex;
            if(taken[neighbourVertex]){
                return true;
            }
            if(!isVisited[neighbourVertex]){
                if(DFS(neighbourVertex,graph,isVisited,stack,taken)) return true;
            }
        }
        stack.push(src);
        return false;
    }
}