import utils.*;
import java.util.*;
class main{


    //using BFS we can detect cycle in directed graph. Idea is to use degree of vertex.
    //if we have |V| vertices and we pop N no. of verticec from queue.
    //if|V|==N then there is no cycle. else there is a cycle.

    static boolean hasCycle(ArrayList<Edge> graph[]){
        int noOfNode = graph.length;
        int degree[] = new int[noOfNode];
        LinkedList<Integer> topologicalPrint = new LinkedList<>();
        boolean cycle = true;
        for(int i=0;i<noOfNode;i++){
            for(Edge e : graph[i]){
                degree[e.vertex]++;
            }
        }
        int noOfPopedVerticex=0;
        //BFS Approach.
        Queue<Integer> queue = new LinkedList<>();
        for(int item : degree){
            if(item==0) queue.add(item);
        }
        while(queue.size()>0){
            int currentVertex = queue.remove();
            topologicalPrint.addLast(currentVertex);
            for(Edge e : graph[currentVertex]){
                int val = --degree[e.vertex];
                if(val==0) queue.add(e.vertex);
            }
            noOfPopedVerticex++;
        }
        return noOfPopedVerticex==noOfPopedVerticex;
    }

    // Algorighm-
    // 1.[VARIABLE INITIALIZATION] degree[|V|]={0},noOfNode=|V|,count_of_poped_vertices=0,
    // 2.calculate degree of all vertices (in degree).
    // 3.push all vertex which is having 0 degree to Q (QUEUE).
    // 4.while Q!=null
    //     4.1. pop vertex from queue currentVertex <-Q.pop().
    //     4.2. for all neighbour vertex of currentVertex.
    //         4.2.1. decrement neighbour vertex degree by 1.
    //         4.2.2. if new degree becomes 0 push into the Q.
    //     4.3. count_of_poped_vertices++.
    // 5. if noOfNode==noOfPopedVerticex return false else true.
                


    

    public static void main(String args[]){
        Graph g = new Graph(5);
        ArrayList<Edge> graph[] = g.graph;
        g.addEdge(0,1,0,false);
        g.addEdge(1,2,0,false);
        g.addEdge(2,4,0,true);
        g.addEdge(2,3,0,false);
        g.addEdge(3,0,0,false);
        // g.display();
        System.out.println(hasCycle(graph));


    }
}