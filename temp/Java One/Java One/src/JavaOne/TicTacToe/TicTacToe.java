package JavaOne.TicTacToe;

import java.util.Scanner;

public class TicTacToe {

    private Player player1, player2;
    private Board board;

    public static void main(String[] args) {
        TicTacToe t = new TicTacToe();
        t.startGame();
    }

    public void startGame(){
        Scanner sc = new Scanner(System.in); 
        //take players input
         player1 = takePlayerInput(1);
         player2 = takePlayerInput(2);

         //checking whether the player 2 symbol is same as 1
         while(player1.getSymbol() == player2.getSymbol()){
            System.out.println("Symbol is already taken !");
            player2.setSymbol((sc.next().charAt(0)));
         }


         //create the board

         board = new Board(player1.getSymbol(), player2.getSymbol()); 
         
         //play the game

         boolean player1Turn = true;
         int status = board.INCOMPLETE;
         while (status == board.INCOMPLETE || status == board.INVALIDMOVE) {
            
            if(player1Turn){
                System.out.println("Player 1 - " + player1.getName()+"'s turn");
                System.out.println("Enter x : ");
                int x = sc.nextInt();
                System.out.println("Enter y : ");
                int y = sc.nextInt();

                status = board.move(player1.getSymbol(), x, y);

                if(status == board.INVALIDMOVE){
                    System.out.println("Invalid Move!! please try again");
                    continue;
                }

            }else{

                System.out.println("Player 2 - " + player1.getName()+"'s turn");
                System.out.println("Enter x : ");
                int x = sc.nextInt();
                System.out.println("Enter y : ");
                int y = sc.nextInt();

                status = board.move(player2.getSymbol(), x, y);

                if(status == board.INVALIDMOVE){
                    System.out.println("Invalid Move!! please try again");
                    continue;
                }

            }

            //toggling the turn
            player1Turn = !player1Turn;
            board.print();

         }

         if(status == board.PLAYER1WINS){
            System.out.println("player - 1 "+player1.getName()+" wins !!");
         }else if(status == board.PLAYER2WINS){
            System.out.println("player - 2 "+player2.getName()+" wins !!");
         }else{
            System.out.println("DRAW !!");
         }

    }

    // take player input
    private Player takePlayerInput(int num) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Player " + num + " name : ");
        String name = sc.nextLine();
        System.out.println("Enter Player " + num + " symbol : ");
        char symbol = sc.next().charAt(0);
        Player p = new Player(name, symbol);
        return p;

    }

}
