interface Chat{
    public void display();
}

class RealChat implements Chat{
    private String user;

    public RealChat(String user){
        this.user = user;
        loadFromDatabase(user);
    }

    private void loadFromDatabase(String user){
        System.out.println("Loading " + user + "'s chat.....");
    }

    @Override
    public void display() {
        System.out.println("displaying " + user + "'s chat...");
    }
}

class ProxyChat implements Chat{
    private RealChat realChat;
    private String user;

    public ProxyChat(String user){
        this.user = user;
    }

    @Override
    public void display() {
        if(realChat==null){ realChat = new RealChat(user);}
        realChat.display();
    }
}

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        Chat chat = new ProxyChat("jay");
        chat.display();

        //displaying without database call
        System.out.println();

        chat.display();
    }
}