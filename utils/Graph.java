package utils;
import utils.Edge;
import java.util.ArrayList;
public class Graph{
    public ArrayList<Edge> graph[];
    public Graph(int size){
        this.graph = new ArrayList[size];
        for(int i=0;i<size;i++){
            this.graph[i]=new ArrayList<>();
        }
    }
    public void addEdge(int u , int v  , int weight  , boolean bidir){
        if(u>=0 && u<this.graph.length && v>=0 && v<this.graph.length){
            this.graph[u].add(new Edge(v,weight));
            if(bidir){
                this.graph[v].add(new Edge(u,weight));
            }
        }
    }
    public void display(){
        for(int i=0;i<this.graph.length;i++){
            System.out.print(i+"->");
            for(Edge e  : this.graph[i]){
                System.out.print("("+e.vertex+"|"+e.weight+"),");
            }
            System.out.println();
        }
    }
}