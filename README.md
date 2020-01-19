# Graph-Theory Algorithms
A Graph is a non-linear data structure consisting of nodes and edges. The nodes are sometimes also referred to as vertices and the edges are lines or arcs that connect any two nodes in the graph. More formally a Graph can be defined as,
<br>```A Graph consists of a finite set of vertices(or nodes) and set of Edges which connect a pair of nodes.```
<br>
<img width = "500px"  src =  "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b0/Path-graph-theory.svg/1280px-Path-graph-theory.svg.png">
<br>
**Language :** Java <br>
**References :** GeeksForGeeks, Introduction to Programing CLRS<br>

## List of Algorithms

- BFS
- BFS COLORING
- DFS
- CONNECTED COMPONENTs DFS
- CYCLE DETECTION IN UNDIRECTED GRAPH DFS
- CYCLE DETECTION IN UNDIRECTED GRAPH BFS
- CYCLE DETECTION IN DIRECTED GRAPH
- TOPOLOGICAL SORT
- KAHN'S ALGORITHM FOR TOPOLOGICAL SORT
- KRUSKALS MST
- Hamiltonian Path

## Pseudocode
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
#### Bredth First Search using Coloring Method.
```
BFS(s, G)
    s <- source vertex
    G <- Graph
    let Q <- queue
    let color[] <- 1 WHITE
    Q.enqueue s
    color of s <- 2 GREY
    while Q is not Empty
        let currentVertex = Q.dequeue.
        color of currentVertex <- BLACK
        for all neighbour of currentVertex
            if color of neighbour is WHITE
                set color of neighbour <- GREY
                Q.enqueue neighbour
        end of for
    end of while
```

#### Depth First Search (DFS)
```
DFS(s , G)
    s <- source vertex
    G <- Graph
    let S <- stack
    S.push s
    set s as visited.
    while S is not Empty
        let currentVertex <- S.pop()
        for all neighbour of currentVertex
            if neighbour is not visited
                set neighbour to visited
                S.push(neighbour)
        end of for
    end of while    
```
#### Connected Components

```
DFS(s , G , visited)
    s <- source vertex
    G <- Graph
    visited <- boolean array
    let S <- Stack
    S.push(s)
    set visited of s <- true
    while S is not empty
        let currentVertex <- S.pop()
        for all neighbour of currentVertex
            if neighbour is not visited
                set visited of neighbour <- true
                S.push(neighbour)
        end of for
    end of while

CC(s,G)
    s <- source vertex
    G <- Graph
    let visited[] <- false (initially none vertex is visited.)
    let count <- 0
    for all vertex of G
        if vetex is not visited
            DFS(vertex ,G , visited)
            incremrnt count
    end of for
    return count.
```

#### Hamiltonian Path
```
hamiltonianPath(src,graph,visited,count,res)
    src <- source vertex
    graph <- Graph
    visited <- boolean Array
    count <- count of edges covered so far
    res <- String containing coverted vertex to print
    append src to res
    if count is equal to |V-1| then print res and return 1
    set visited(src) <- true
        for all neighbour of graph(src)
            if neighbour is not visited
                set neighbour to visited
                count += hamiltonianPath(neighbour,graph,visited,count+1,res)
        end of for
    return count
```




