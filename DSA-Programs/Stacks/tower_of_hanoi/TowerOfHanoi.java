package Stacks.tower_of_hanoi;


import java.util.Stack;

public class TowerOfHanoi {

    static class Move {
        int n;
        char from, to, aux;

        Move(int n, char from, char to, char aux) {
            this.n = n;
            this.from = from;
            this.to = to;
            this.aux = aux;
        }
    }

    static void towerOfHanoi(int n, char from, char to, char aux) {
        Stack<Move> stack = new Stack<>();
        stack.push(new Move(n, from, to, aux));

        while (!stack.isEmpty()) {
            Move move = stack.pop();

            if (move.n == 1) {
                System.out.println("Move disk 1 from " + move.from + " to " + move.to);
            } else {
                // Push the next recursive moves onto the stack
                stack.push(new Move(move.n - 1, move.aux, move.to, move.from));
                stack.push(new Move(1, move.from, move.to, move.aux));
                stack.push(new Move(move.n - 1, move.from, move.aux, move.to));
            }
        }
    }

    public static void main(String[] args) {
        int n = 3; // Number of disks
        towerOfHanoi(n, 'A', 'C', 'B');
    }
}
