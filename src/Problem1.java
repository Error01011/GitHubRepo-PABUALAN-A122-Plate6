import java.util.LinkedList;
import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices: ");
        Graph graph = new Graph(sc.nextInt(), false);
        System.out.print("Enter number of edges: ");
        int edges = sc.nextInt();
        for(int i = 0; i < edges; i++){
            System.out.print("Enter the edge #"+(i+1)+" (ex: 0 1): ");
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.addEdge(u, v);
        }
        if(graph.isConnected()){
            System.out.println("The graph is connected!");
        } else {
            System.out.println("The graph is not connected but there are "+graph.getConnnectedComponents()+" connected components");
        }
    }
}
