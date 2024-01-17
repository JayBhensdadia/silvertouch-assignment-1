

import java.util.LinkedList;

class HashTable<K, V> {
    private static final int TABLE_SIZE = 10;
    private LinkedList<Entry<K, V>>[] table;

    public HashTable() {
        table = new LinkedList[TABLE_SIZE];
        for (int i = 0; i < TABLE_SIZE; i++) {
            table[i] = new LinkedList<>();
        }
    }

    public void insert(K key, V value) {
        int index = hash(key);
        LinkedList<Entry<K, V>> bucket = table[index];

        
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }

        
        bucket.add(new Entry<>(key, value));
    }

    public V search(K key) {
        int index = hash(key);
        LinkedList<Entry<K, V>> bucket = table[index];

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                return entry.value; 
            }
        }

        return null; 
    }

    public void delete(K key) {
        int index = hash(key);
        LinkedList<Entry<K, V>> bucket = table[index];

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                bucket.remove(entry);
                return;
            }
        }
    }

    private int hash(K key) {
        return key.hashCode() % TABLE_SIZE;
    }

    private static class Entry<K, V> {
        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        HashTable<String, Integer> hashTable = new HashTable<>();

      
        hashTable.insert("Jay", 25);
        hashTable.insert("Ajay", 30);
        hashTable.insert("Vijay", 35);

        
        System.out.println("Age of Jay: " + hashTable.search("Jay"));
        System.out.println("Age of Ajay: " + hashTable.search("Ajay"));
        System.out.println("Age of Vijay: " + hashTable.search("Vijay"));

        
        hashTable.delete("Ajay");

        
        System.out.println("Age of Ajay after deletion: " + hashTable.search("Ajay")); 
    }
}
