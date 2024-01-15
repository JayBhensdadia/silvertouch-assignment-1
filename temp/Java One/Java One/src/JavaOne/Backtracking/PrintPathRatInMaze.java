package JavaOne.Backtracking;

public class PrintPathRatInMaze {

    public static void printPathToDestination(int[][] maze){
        int[][] path = new int[maze.length][maze.length];

        helper(maze,0,0,path);

    }

    public static void printPath(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(arr[i][j]==1){
                    System.out.print(arr[i][j]+" ");
                }else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        
    }

    public static boolean helper(int[][] maze, int i, int j, int[][] path){
        //check if the cell i,j is valid or not
        int n = maze.length;
        if(i<0 || i>=n || j<0 || j>=n || path[i][j]==1 || maze[i][j]==0){
            return false;
        }
        //include the cell in current path
        path[i][j] = 1;

        //if destination cell
        if(i==n-1 && j==n-1){
            printPath(path);
            return true;
        }

        //explore further in all direction

        //top
        if(helper(maze, i-1, j, path)){
            return true;
        }
        //right
        if(helper(maze, i, j+1, path)){
            return true;
        }
        //down
        if(helper(maze, i+1, j, path)){
            return true;
        }
        //left
        if(helper(maze, i, j-1, path)){
            return true;
        }

        return false;
    }
    public static void main(String[] args) {
        int[][] maze = {{1,1,0},{1,1,0},{1,1,1}};
        printPathToDestination(maze);
    }
}
