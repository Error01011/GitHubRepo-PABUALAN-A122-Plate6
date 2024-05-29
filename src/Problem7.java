import java.util.Arrays;
import java.util.Scanner;

public class Problem7 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices: ");
        int vertices = sc.nextInt();
        Graph graph = new Graph(vertices, false);
        System.out.print("Enter number of edges: ");
        int edges = sc.nextInt();
        int[][] incidenceMatrix = new int[vertices][edges];
        for(int i = 0; i < edges; i++){
            System.out.print("Enter the edge #"+(i+1)+" (ex: 0 1): ");
            int u = sc.nextInt();
            int v = sc.nextInt();
            System.out.print("How many times did the edge appears?: ");
            int count = sc.nextInt();
            for(int j = 0; j<count;j++) {
                graph.addEdge(u, v);
                incidenceMatrix[u][i+j] = 1;
                incidenceMatrix[v][i+j] = 1;
            }
            if(count>=1) i+=count-1;
        }
        for(int[] rows: incidenceMatrix){
            System.out.println(Arrays.toString(rows));
        }


    }
}
