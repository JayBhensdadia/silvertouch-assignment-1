import java.util.ArrayList;
import java.util.List;

class Channel{

    String name;
    List<Subscriber> subs = new ArrayList<>();

    public Channel(){}
    public Channel(String name){
        this.name = name;
    }

    public void subscribe(Subscriber s){
        subs.add(s);
    }

    public void notifyAllSubs(){
        for (Subscriber sub : subs) {
            sub.update();
        }
    }

    public void uploadVideo(){
        notifyAllSubs();
    }
}

class Subscriber{
    private String name;
    private Channel channel = new Channel();

    public Subscriber(String name){
        this.name = name;
    }


    public void update(){
        System.out.println("Hey " + name + ", new video is uploaded");
    }

    public void subscribe(Channel channel){
        this.channel = channel;
        channel.subscribe(this);
    }
}


public class Main {

    public static void main(String[] args) {
        Channel jb = new Channel("jb");

        Subscriber s1 = new Subscriber("jay");
        Subscriber s2 = new Subscriber("ajay");
        Subscriber s3 = new Subscriber("vijay");

        s1.subscribe(jb);
        s2.subscribe(jb);
        s3.subscribe(jb);


        jb.uploadVideo();
    }
    
}
