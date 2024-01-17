package Application_Based;

import java.util.LinkedList;
import java.util.Queue;

public class MazeShortestPath {

    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; 

    public static int shortestPath(int[][] maze, int[] start, int[] destination) {
        int rows = maze.length;
        int cols = maze[0].length;

        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(start);
        visited[start[0]][start[1]] = true;

        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();

                if (current[0] == destination[0] && current[1] == destination[1]) {
                    return steps;
                }

                for (int[] dir : DIRECTIONS) {
                    int newRow = current[0] + dir[0];
                    int newCol = current[1] + dir[1];

                    if (isValidMove(newRow, newCol, maze, visited)) {
                        queue.offer(new int[]{newRow, newCol});
                        visited[newRow][newCol] = true;
                    }
                }
            }

            steps++;
        }

        return -1; 
    }

    private static boolean isValidMove(int row, int col, int[][] maze, boolean[][] visited) {
        int rows = maze.length;
        int cols = maze[0].length;

        return row >= 0 && row < rows && col >= 0 && col < cols && maze[row][col] == 0 && !visited[row][col];
    }

    public static void main(String[] args) {
        int[][] maze = {
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 1},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 1, 0}
        };

        int[] start = {0, 0};
        int[] destination = {4, 4};

        int shortestPathLength = shortestPath(maze, start, destination);

        if (shortestPathLength != -1) {
            System.out.println("Shortest Path Length: " + shortestPathLength);
        } else {
            System.out.println("No valid path found.");
        }
    }
}
