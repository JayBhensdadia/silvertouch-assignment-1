package JavaOne.Backtracking;

public class RatInMaze {
    public static boolean isSolvable(int[][] maze){
        int n = maze.length;
        int[][] path = new int[n][n];

        return isSolvableHelper(maze,0,0,path);
    }
    public static boolean isSolvableHelper(int[][] maze, int i, int j, int[][] path){
        //check if the cell i,j is valid or not
        int n = maze.length;
        if(i<0 || i>=n || j<0 || j>=n || path[i][j]==1 || maze[i][j]==0){
            return false;
        }
        //include the cell in current path
        path[i][j] = 1;

        //if destination cell
        if(i==n-1 && j==n-1){
            return true;
        }

        //explore further in all direction

        //top
        if(isSolvableHelper(maze, i-1, j, path)){
            return true;
        }
        //right
        if(isSolvableHelper(maze, i, j+1, path)){
            return true;
        }
        //down
        if(isSolvableHelper(maze, i+1, j, path)){
            return true;
        }
        //left
        if(isSolvableHelper(maze, i, j-1, path)){
            return true;
        }

        return false;

    }
    public static void main(String[] args) {
        int[][] maze = {{1,1,0},{1,1,0},{1,1,1}};
        System.out.println(isSolvable(maze));
    }
}
