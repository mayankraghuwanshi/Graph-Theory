// import utils.*;
import java.io.*;
import java.util.*;
class main{
    static class Edge{
        int srcVertex;
        int desVertex;
        int weight;
        Edge(int u , int v , int w){
            this.srcVertex=u;
            this.desVertex=v;
            this.weight=w;
        }
        Edge(){
            this.srcVertex=0;
            this.desVertex=0;
            this.weight=0;
        }
    }
    public static void main(String args[]){
        int E=14;
        int V=9;
        Edge graph[] = new Edge[E];
        Edge output[] = new Edge[V-1];
        graph[0]=new Edge(0,1,4);
        graph[1]=new Edge(0,8,8);
        graph[2]=new Edge(1,7,11);
        graph[3]=new Edge(1,2,8);
        graph[4]=new Edge(2,8,2);
        graph[5]=new Edge(7,8,7);
        graph[6]=new Edge(7,6,1);
        graph[7]=new Edge(8,6,6);
        graph[8]=new Edge(2,5,4);
        graph[9]=new Edge(2,3,7);
        graph[10]=new Edge(3,5,14);
        graph[11]=new Edge(6,5,2);
        graph[12]=new Edge(3,4,9);
        graph[13]=new Edge(5,4,10);
        Arrays.sort(graph , new Comparator<Edge>(){
            @Override
            public int compare(Edge e1, Edge e2){
                return e1.weight-e2.weight;
            }
        });
        //cycle detection left.
        for(int i=0;i<V-1;i++){
            Edge currentEdge = graph[i];
            output[i]=new Edge(currentEdge.srcVertex,currentEdge.desVertex,currentEdge.weight);
        }
        
        for(Edge e : output){
            System.out.println(e.srcVertex+"->("+e.desVertex+"|"+e.weight+")");
        }
    }   
}