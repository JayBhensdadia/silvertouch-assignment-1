abstract class Game{
    abstract void initialize();
    abstract void start();
    abstract void end();

    public final void play(){
        initialize();
        start();
        end();
    }
}

class Chess extends Game{
    @Override
    void initialize() {
        System.out.println("set up the chess board");
    }

    @Override
    void start() {
        System.out.println("make your moves");
    }

    @Override
    void end() {
        System.out.println("finish the game and appriciate the winner");
    }
}

class Football extends Game{
    @Override
    void initialize() {
        System.out.println("divide player into teams");
    }

    @Override
    void start() {
        System.out.println("make goals....");
    }

    @Override
    void end() {
        System.out.println("finish the game and the team with highest goal wins");
    }
}


/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        Game chess = new Chess();
        Game football = new Football();

        chess.play();
        System.out.println();
        football.play();
    }
}