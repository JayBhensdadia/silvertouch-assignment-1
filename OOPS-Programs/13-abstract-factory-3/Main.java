interface MobileUIComponent{}
interface DesktopUIComponent{}


class MButton1 implements MobileUIComponent{
    public MButton1(){
        System.out.println("Button for mobile application with style-1 created");
    }
}

class MButton2 implements MobileUIComponent{
    public MButton2(){
        System.out.println("Button for mobile application with style-2 created");
    }
}


class DButton1 implements DesktopUIComponent{
    public DButton1(){
        System.out.println("Button for desktop application with style-1 created");
    }
}

class DButton2 implements DesktopUIComponent{
    public DButton2(){
        System.out.println("Button for desktop application with style-2 created");
    }
}


abstract class AbstractFactory{
    public abstract MobileUIComponent getMobileComponent();
    public abstract DesktopUIComponent getDesktopComponent();
}

class ConcreteFactory1 extends AbstractFactory{
    @Override
    public MobileUIComponent getMobileComponent() {
        return new MButton1();
    }

    @Override
    public DesktopUIComponent getDesktopComponent() {
        return new DButton1();
    }
}

class ConcreteFactory2 extends AbstractFactory{
    @Override
    public MobileUIComponent getMobileComponent() {
        return new MButton2();
    }

    @Override
    public DesktopUIComponent getDesktopComponent() {
        return new DButton2();
    }
}


/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        AbstractFactory f1 = new ConcreteFactory1();
        AbstractFactory f2 =new ConcreteFactory2();

        f1.getMobileComponent();
        f2.getDesktopComponent();
    }
}

