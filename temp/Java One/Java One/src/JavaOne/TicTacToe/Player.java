package JavaOne.TicTacToe;

public class Player {
    
    private String name;
    private char symbol;

    //constructor
    public Player(String name, char symbol){
        setName(name);
        setSymbol(symbol);
    }

    //set name
    public void setName(String name) {
        if(!name.isEmpty()){
            this.name = name;
        }
    }

    //get name
    public String getName() {
        return name;
    }

    //set symbol
    public void setSymbol(char symbol) {
        if(symbol != '\0'){
            this.symbol = symbol;
        }
    }

    //get symbol
    public char getSymbol() {
        return symbol;
    }

}
