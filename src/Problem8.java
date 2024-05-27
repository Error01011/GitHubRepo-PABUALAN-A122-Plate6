import java.util.*;

public class Problem8 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Graph[] graphs = new Graph[2];
        int[] edges = new int[2];
        for(int graph=0;graph<2;graph++) {
            System.out.println("Graph #"+(graph+1));
            System.out.print("Enter number of vertices: ");
            int vertices = sc.nextInt();
            graphs[graph] = new Graph(vertices, false);
            System.out.print("Enter number of edges: ");
            edges[graph] = sc.nextInt();
            for (int i = 0; i < edges[graph]; i++) {
                System.out.print("Enter the pair of vertices #" + (i + 1) + " (ex: 0 1): ");
                int u = sc.nextInt();
                int v = sc.nextInt();
                graphs[graph].addEdge(u, v);
            }
        }
        //Checks if they have similar vertices, and amount of edges
        if((graphs[0].getVertices()!=graphs[0].getVertices()) || graphs[0].getConnnectedComponents() != graphs[1].getConnnectedComponents()
                || edges[0]!=edges[1]){
            System.out.println("The two graphs provided are not isomorphic");
            return;
        }
        for(int i=0; i<graphs[0].getVertices();i++){
            graphs[0].dfs(i,-1);
            graphs[1].dfs(i,-1);
        }
        //Check if they have similar degree sequence and cycle truth value
        ArrayList<Integer>[] degreeSequences = new ArrayList[2];
        degreeSequences[0] = new ArrayList<Integer>();
        degreeSequences[1] = new ArrayList<Integer>();
        for(int i=0;i<graphs[0].getVertices();i++){
            degreeSequences[0].add(graphs[0].getEdges()[i].size());
            degreeSequences[1].add(graphs[1].getEdges()[i].size());
        }
        Collections.sort(degreeSequences[0]);
        Collections.sort(degreeSequences[1]);
        if(graphs[0].isCycle() != graphs[1].isCycle() || !degreeSequences[0].equals(degreeSequences[1])){
            System.out.println("The two graphs provided are not isomorphic");
            return;
        }
        System.out.println("The two graphs provided are isomorphic");
    }

}
