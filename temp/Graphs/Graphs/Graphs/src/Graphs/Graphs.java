package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


/**
 * Graphs
 * 
 * assumption : graph vertices are numbers
 */
public class Graphs {

    public static boolean isConnected(int[][] adjMatrix){
        int[] visited = new int[adjMatrix.length];
        Queue<Integer> queue = new LinkedList<>();
        boolean isConnected = true;

        visited[0] = 1;
        queue.add(0);
        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            
            for (int i = 0; i < adjMatrix.length; i++) {
                if (adjMatrix[currentVertex][i] == 1 && visited[i] == 0) {
                    visited[i] = 1;
                    queue.add(i);
                }
            }
        }

        for(int i = 0; i < visited.length; i++){
            if(visited[i]==0){
                isConnected = false;
                break;
            }
        }
        return isConnected;
    }

    public static ArrayList<Integer> getPathBFS(int[][] adjMatrix, int source, int destination){
        
        int[] visited = new int[adjMatrix.length];
        int[] parent = new int[adjMatrix.length];
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> path = new ArrayList<>();
		boolean pathFound = false;
        
		parent[source] = -1;
        visited[source] = 1;
        queue.add(source);
        
        while(!queue.isEmpty()){
            int currentVertex = queue.poll();
            for (int i = 0; i < adjMatrix.length; i++) {
                if (adjMatrix[currentVertex][i] == 1 && visited[i] == 0) {
                    parent[i] = currentVertex;
                    visited[i] = 1;
                    queue.add(i);
                    if(i==destination){
						pathFound = true;
                        break;
                    }
                   
                }
            }
        }
		if(pathFound){
				path.add(destination);
        		int j = destination;
        		while(j!=source){
            		path.add(parent[j]);
            		j = parent[j];
       			 }
		}else{
			path = null;
		}
        

        return path;

    }
    public static ArrayList<Integer> getPath(int[][] adjMatrix,int[] visited, int source, int destination){
        
        visited[source] = 1;

        if(source==destination){
            ArrayList<Integer> ans = new ArrayList<>();
            ans.add(source);
            return ans;
        }

       

       for (int i = 0; i < adjMatrix.length; i++) {
            ArrayList<Integer> tempAns = null;
            if(adjMatrix[source][i]==1 && visited[i]==0){
                tempAns = getPath(adjMatrix, visited, i, destination);
                
            }
            if(tempAns!=null){
                tempAns.add(source);
                return tempAns;
            }
            
            
       }

       return null;

    }

    public static boolean hasPathDFS(int[][] adjMatrix, int[] visited, int source, int destination) {
        if (source == destination) {
            return true;
        }
        visited[source] = 1;
        for (int i = 0; i < adjMatrix.length; i++) {
            boolean ans = false;
            if (adjMatrix[source][i] == 1 && visited[i] == 0) {
                ans = hasPathDFS(adjMatrix, visited, i, destination);
            }
            if (ans) {
                return true;
            }

        }
        return false;
    }

    // T(v) = O(v^2)
    public static void BFS(int[][] adjMatrix, int[] visited, int start, Queue<Integer> queue) {

        visited[start] = 1;
        queue.add(start);
        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            System.out.print(currentVertex + " ");
            for (int i = 0; i < adjMatrix.length; i++) {
                if (adjMatrix[currentVertex][i] == 1 && visited[i] == 0) {
                    visited[i] = 1;
                    queue.add(i);
                }
            }
        }

    }

    // T(v) = O(v^2)
    public static void DFS(int[][] adjMatrix, int[] visited, int start) {

        visited[start] = 1;
        System.out.print(start + " ");
        for (int i = 0; i < adjMatrix.length; i++) {
            if (adjMatrix[start][i] == 1 && visited[i] == 0) {
                DFS(adjMatrix, visited, i);
            }
        }

    }

    public static void BFSForDisconnected(int[][] adjMatrix) {
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[adjMatrix.length];
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == 0) {
                BFS(adjMatrix, visited, i, queue);
                System.out.println();
            }
        }
    }

    public static void DFSForDisconnected(int[][] adjMatrix) {
        int[] visited = new int[adjMatrix.length];
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == 0) {
                DFS(adjMatrix, visited, i);
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int e = sc.nextInt();

        int adjMatrix[][] = new int[n][n];

        for (int i = 0; i < e; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();

            adjMatrix[v1][v2] = 1;
            adjMatrix[v2][v1] = 1;
        }

        // for (int i = 0; i < n; i++) {
        // for (int j = 0; j < n; j++) {
        // System.out.print(adjMatrix[i][j] + " ");
        // }
        // System.out.println();
        // }

        // DFS(adjMatrix, new int[n], 0);
        // BFS(adjMatrix, new int[n], 0, new LinkedList<>());
        // bfTraversal(adjMatrix);
        // System.out.println(hasPathDFS(adjMatrix, new int[adjMatrix.length], 0, 1));
        // DFSForDisconnected(adjMatrix);
        //BFSForDisconnected(adjMatrix);

        ArrayList<Integer> path = getPathBFS(adjMatrix,0,4);
        System.out.println(path);
    }

}