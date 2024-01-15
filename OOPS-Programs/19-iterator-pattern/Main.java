interface Iterator{
    public boolean hasNext();
    public Object next();
}

interface Collection{
    public Iterator getIterator();
}

 class JBArray implements Collection{
    public String[] names = {"jay","ajay","vijay","sanjay"};

    @Override
    public Iterator getIterator() {
        return new NameIterator();
    }

    class NameIterator implements Iterator{
        int index;

        @Override
        public boolean hasNext() {
            if(index < names.length){return true;}
            return false;
        }

        @Override
        public Object next() {
            if(this.hasNext()){
                return names[index++];
            }
            return null;
        }
    }

}


/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        JBArray arr = new JBArray();

        Iterator iter = arr.getIterator();

        while (iter.hasNext()) {
            System.out.println("Name: " + iter.next());
        }
    }
}