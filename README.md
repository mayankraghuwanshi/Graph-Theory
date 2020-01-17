# Graph-Theory Algorithms
A Graph is a non-linear data structure consisting of nodes and edges. The nodes are sometimes also referred to as vertices and the edges are lines or arcs that connect any two nodes in the graph. More formally a Graph can be defined as,```A Graph consists of a finite set of vertices(or nodes) and set of Edges which connect a pair of nodes.```
<br><br>
**Language :** Java <br>
**References :** GeeksForGeeks, Introduction to Programing CLRS<br>
##List of Algorithms

- BFS
- BFS COLORING
- DFS
- CONNECTED COMPONENTs DFS
- CYCLE DETECTION IN UNDIRECTED GRAPH
- CYCLE DETECTION IN DIRECTED GRAPH
- TOPOLOGICAL SORT
- KAHN'S ALGORITHM FOR TOPOLOGICAL SORT
- KRUSKALS MST

##Pseudocode
#### Bredth First Search (BFS)
```
let s<-Source node.
let G<-Graph
let Q<-queue
Q.enqueue s.
mark s as visited.
while Q is no empty
    let currentVertex<-Q.dequeue.
    for all neighbourVertex of currentVertex
    if neighbourVertex is not visited
        Q.enqueue neighbourVertex
        mark neighbourVertex as visited
    end of for loop.
end of while loop.
```




