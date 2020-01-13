import java.util.*;
import utils.Graph;
import utils.Edge;
class main{
    //using recursion.
    static void BFS(ArrayList<Edge> graph[] , int src , boolean isVisited[]){
        System.out.print(src+"->");
        isVisited[src]=true;
        for(Edge e : graph[src]){
            if(!isVisited[e.vertex]){
                BFS(graph, e.vertex , isVisited);
            }
        }
    }
    //using stack
    static void BFS(ArrayList<Edge> graph[] , int src){
        boolean isVisited[] = new boolean[graph.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(src);
        StringBuilder output = new StringBuilder();
        isVisited[src]=true;
        while(stack.size()>0){
            int popedVertex = stack.pop();
            output.append(popedVertex+"->");
            for(Edge e : graph[popedVertex]){
                int currentVertex = e.vertex;
                if(!isVisited[currentVertex]){
                    isVisited[currentVertex]=true;
                    stack.push(currentVertex);
                }
            }
        }
        System.out.println(output.substring(0,output.length()-2));
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
        BFS(graph,1,new boolean[graph.length]);
        System.out.println();
        BFS(graph,1);
               
    }
}