interface Text{
    public String content();
}

class PlainText implements Text{

    @Override
    public String content() {
        return "this is PLAIN text";
    }
}

class Decorator implements Text{
    private Text txt;

    public Decorator(Text txt){
        this.txt = txt;
    }

    @Override
    public String content() {
        return this.txt.content();
    }
}


class Bold extends Decorator{
    public Bold(Text text){
        super(text);
    }

    @Override
    public String content() {
        return super.content() + " and BOLD text";
    }
}


class Italic extends Decorator{
    public Italic(Text text){
        super(text);
    }

    @Override
    public String content() {
        return super.content()+" and ITALIC text";
    }
}


class Underline extends Decorator{
    public Underline(Text text){
        super(text);
    }

    @Override
    public String content() {
        return "this is ITALIC text";
    }
}

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        
        Text txt1 = new PlainText();
        System.out.println(txt1.content());

        Text txt2 = new Bold(new Italic(new PlainText()));
        System.out.println(txt2.content());
    }
}