package JavaOne.Generics;

public class vehicle implements printInterface {
    int maxSpeed;
    String company;

    public vehicle(int maxSpeed, String company){
        this.maxSpeed = maxSpeed;
        this.company = company;
    }

    public void print(){
        System.out.println(maxSpeed+" "+company);
    }

    
}
