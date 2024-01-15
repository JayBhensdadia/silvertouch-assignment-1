interface ProductA{}
interface ProductB{}

class ProductA1 implements ProductA {
    public ProductA1(){
        System.out.println("Product A1 is created!");
    }
}

class ProductA2 implements ProductA{
    public ProductA2(){
        System.out.println("Product A2 is created!");
    }
}


class ProductB1 implements ProductB{
    public ProductB1(){
        System.out.println("Product B1 is created!");
    }
}

class ProductB2 implements ProductB{
    public ProductB2(){
        System.out.println("Product B2 is created!");
    }
}

abstract class AbstractFactory{
    public abstract ProductA getProductA();
    public abstract ProductB getProductB();
}


class ConcreteFactory1 extends AbstractFactory{
    @Override
    public ProductA getProductA() {
        return new ProductA1();
    }

    @Override
    public ProductB getProductB() {
        return new ProductB1();
    }
}

class ConcreteFactory2 extends AbstractFactory{
    @Override
    public ProductA getProductA() {
        return new ProductA2();
    }

    @Override
    public ProductB getProductB() {
        return new ProductB2();
    }
}

public class Main {
    public static void main(String[] args) {
        ConcreteFactory1 cf1 = new ConcreteFactory1();
        ConcreteFactory2 cf2 = new ConcreteFactory2();

        cf1.getProductA();
        cf2.getProductA();
    }
}
