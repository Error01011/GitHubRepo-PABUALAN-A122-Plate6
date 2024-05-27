import java.util.Scanner;

public class Problem4 {
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
        for(int i=0; i<vertices;i++){
            System.out.println("Degree of vertex "+i+": "+graph.getEdges()[i].size());
        }

    }
}
