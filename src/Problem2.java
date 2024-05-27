import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices: ");
        int vertices = sc.nextInt();
        int[][] adjMatrix = new int[vertices][vertices];

        for (int i=0; i<vertices;i++){
            System.out.print("Enter the values for Row #"+(i+1)+" (ex. 1 0 1 1): ");
            for(int j=0; j<vertices;j++){
                adjMatrix[i][j] = sc.nextInt();
            }
        }
        System.out.println("List of Edges:");
        for(int i=0; i<vertices;i++){
            for(int j=0; j<vertices;j++){
                if(adjMatrix[i][j] != 0){
                    System.out.println(" - ("+i+","+j+") Weight: "+adjMatrix[i][j]);
                }
            }
        }
    }
}
