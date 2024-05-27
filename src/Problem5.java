import java.util.*;

public class Problem5 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices: ");
        int vertices = sc.nextInt();
        Graph graph = new Graph(vertices, false);
        System.out.print("Enter number of edges: ");
        int edges = sc.nextInt();
        for(int i = 0; i < edges; i++){
            System.out.print("Enter the edge #"+(i+1)+" (ex: 0 1): ");
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.addEdge(u, v);
        }
        graph.checkBipartite();
        if(graph.isBipartite()){
            System.out.println("The graph is a bipartite!");
        } else {
            System.out.println("The graph is not a bipartite!");
        }

    }
}
