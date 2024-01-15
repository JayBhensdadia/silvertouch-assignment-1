import java.util.ArrayList;
import java.util.List;

class WeatherStation{
    private String weather;
    List<Subscriber> subs = new ArrayList<>();

    public WeatherStation(){
        this.weather = "cold";
    }

    public WeatherStation(String weather){
        this.weather = weather;
    }

    public void subscribe(Subscriber s){
        subs.add(s);
    }

    public void notifyAllSubs(){
        for (Subscriber sub : subs) {
            sub.update();
        }
    }

    public void setWeather(String weather) {
        this.weather = weather;
        notifyAllSubs();
    }

    public String getWeather() {
        return weather;
    }
}

class Subscriber{
    private String name;
    private WeatherStation station = new WeatherStation();

    public Subscriber(String name){
        this.name = name;
    }

    public void update(){
        System.out.println("Hey," + name+ " Weather update: " + this.station.getWeather());
    }

    public void subscribe(WeatherStation ws){
        this.station = ws;
        ws.subscribe(this);
    }
}

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        
        WeatherStation ws = new WeatherStation();

        Subscriber s1 = new Subscriber("jay");
        Subscriber s2 = new Subscriber("ajay");
        Subscriber s3 = new Subscriber("vijay");

        s1.subscribe(ws);
        s2.subscribe(ws);
        s3.subscribe(ws);

        ws.setWeather("windy");
        
    }
}