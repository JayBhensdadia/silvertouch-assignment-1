package JavaOne.Backtracking;

public class PrintAllPathRat {

    public static void printAllPath(int[][] maze){
        int[][] path = new int[maze.length][maze.length];

        helper(maze,0,0,path);

    }

    public static void printPath(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j]);
            }
            
        }
        System.out.println();
        
    }

    public static void helper(int[][] maze, int i, int j, int[][] path){
        //check if the cell i,j is valid or not
        int n = maze.length;
        if(i<0 || i>=n || j<0 || j>=n || path[i][j]==1 || maze[i][j]==0){
            return;
        }
        //include the cell in current path
        path[i][j] = 1;

        //if destination cell
        if(i==n-1 && j==n-1){
            printPath(path);
            path[i][j] = 0;
            return;
        }

        //explore further in all direction

        //top
        helper(maze, i-1, j, path);
        //down
        helper(maze, i+1, j, path);
        //left
        helper(maze, i, j-1, path);
        //right
        helper(maze, i, j+1, path);
        
            
       
        

        // again setting it to zero
        //so it can also be used in other possible paths
        path[i][j] = 0;
        
    }

    public static void main(String[] args) {
        int[][] maze = {{1, 1, 1},{1, 1, 0 },{0, 1, 1 }};
        printAllPath(maze);
         



    }
}
