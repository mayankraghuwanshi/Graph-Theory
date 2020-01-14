import utils.*;
import java.util.*;
class main{
    //using recursion as a stack.
    static void DFS(ArrayList<Edge> graph[] , int src , boolean isVisited[]){
        isVisited[src]=true;
        System.out.print(src+"->");
        for(Edge e : graph[src]){
            if(!isVisited[e.vertex]){
                isVisited[e.vertex]=true;
                DFS(graph,e.vertex,isVisited);
            }
        }
    }
    //using stack.
    static void DFS(ArrayList<Edge> graph[] , int src){
        boolean isVisited[] = new boolean[graph.length];
        Stack<Integer> stack = new Stack<>();
        isVisited[src]=true;
        stack.push(src);
        StringBuilder output = new StringBuilder();
        while(stack.size()>0){
            int popedVertex = stack.pop();
            output.append(popedVertex+"->");
            for(Edge e : graph[popedVertex]){
                if(!isVisited[e.vertex]){
                    isVisited[e.vertex]=true;
                    stack.push(e.vertex);

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
        DFS(graph,1);
        DFS(graph,1,new boolean[graph.length]);

    }
}
