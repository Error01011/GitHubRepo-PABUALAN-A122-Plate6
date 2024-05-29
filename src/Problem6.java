import java.util.Arrays;
import java.util.Scanner;

public class Problem6 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices: ");
        int vertices = sc.nextInt();
        System.out.print("Is the graph directed or not? (True/False): ");
        Graph graph = new Graph(vertices, sc.nextBoolean());
        System.out.print("Enter number of edges: ");
        int edges = sc.nextInt();
        for(int i = 0; i < edges; i++){
            System.out.print("Enter the edge #"+(i+1)+" (ex: 0 1): ");
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.addEdge(u, v);
        }
        int[][] adjMatrix = new int[vertices][vertices];
        for(int i=0;i<vertices;i++){
            for(int child:graph.getEdges()[i]){
                adjMatrix[i][child]+=1;
            }
        }
        for(int[] rows: adjMatrix){
            System.out.println(Arrays.toString(rows));
        }

    }
}
