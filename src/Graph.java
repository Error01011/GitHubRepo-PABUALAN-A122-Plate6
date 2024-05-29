import java.util.*;

public class Graph {
    private final int vertices;
    private final LinkedList<Integer>[] edges;
    private boolean[] visited;
    private final boolean[] recStack;
    private final boolean isDirected;
    private boolean isCycle;
    private boolean isBipartite;

    public Graph(int vertices, boolean isDirected){
        this.vertices = vertices;
        this.isBipartite = false;
        this.isDirected = isDirected;
        edges = new LinkedList[vertices];
        visited = new boolean[vertices];
        recStack = new boolean[vertices];
        for(int i = 0; i<vertices;i++){
            edges[i] = new LinkedList<>();
        }
    }
    public void addEdge(int a, int b){
        edges[a].add(b);
        if(!isDirected && a!=b)edges[b].add(a);
    }

    public LinkedList<Integer>[] getEdges(){ return edges;}
    public int getVertices(){ return vertices;}
    public boolean isCycle() {
        return isCycle;
    }

    public void dfs(int v, int parent){
        visited[v] = true;
        recStack[v] = true;
        for(int child: edges[v]){
            if(!visited[child]){
                dfs(child, v);
            } else if(!isDirected && child!=parent){
                isCycle= true;
            } else if(isDirected && recStack[child]){
                isCycle= true;
            }
        }
        recStack[v] = false;
    }

    public void checkBipartite(){
        HashMap<Integer, Boolean> status = new HashMap<>();
        visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        do {
            int vec = queue.remove();
            if(!status.containsKey(vec)) status.put(vec,true);
            visited[vec] = true;
            for(int child: edges[vec]){
                if(status.containsKey(child)) {
                    if(status.get(child)==status.get(vec)) {
                        isBipartite = false;
                        return;
                    }
                }
                if(!visited[child] && !queue.contains(child)){
                    status.put(child,!status.get(vec));
                    queue.add(child);
                }
            }
            if(queue.isEmpty() && !isAllVisited()){
                queue.add(getFirstUnvisitedVertex());
            }
        } while (!queue.isEmpty());
        isBipartite=true;
    }

    public boolean isAllVisited(){
        for (boolean b : visited) {
            if (!b) return false;
        }
        return true;
    }
    public int getFirstUnvisitedVertex(){
        for(int i=0; i<visited.length;i++){
            if(!visited[i]) return i;
        }
        return -1;
    }
    public int getConnectedComponents(){
        visited = new boolean[vertices];
        int con = 0;
        for(int i=0;i<visited.length;i++){
            if(!visited[i]){
                con++;
               dfs(i,-1);
            }
        }
        visited = new boolean[vertices];
        return con;
    }
    public boolean isBipartite(){
        return isBipartite;
    }
    public boolean isConnected(){
        visited = new boolean[vertices];
        dfs(0,-1);
        for(int i=0;i<vertices;i++){
            if(!visited[i]){
                return false;
            }
        }
        return true;
    }
}
