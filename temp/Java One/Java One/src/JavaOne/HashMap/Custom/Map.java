package JavaOne.HashMap.Custom;

import java.util.ArrayList;

public class Map<K,V> {
    ArrayList<MapNode<K,V>> buckets;
    int count;
    int numBuckets;

    //constructor
    public Map(){

        buckets = new ArrayList<>();
        numBuckets = 20;
        for(int i = 0; i < numBuckets; i++){
            buckets.add(null);
        }
    }

    //size
    public int size(){
        return count;
    }

    //getValue
    public V getValue(K key){

        int bucketIndex = getBucketIndex(key);
        MapNode<K,V> t = buckets.get(bucketIndex);
        while(t!=null){
            if(t.key.equals(key)){
                return t.value;
            }
            t = t.next;
        }
        return null;

    }

    //getBucketIndex (Hash Function)
    private int getBucketIndex(K key){
        int hc = key.hashCode();
        return hc%numBuckets;
    }

    //rehashing
    private void reHash(){

        //inserting each element of LL of each index of old
        //bucket into new bucket of doulbe size

        //just copying will not work because the compression 
        //fucntion has changed due to changed size

        ArrayList<MapNode<K,V>> temp = buckets;
        buckets = new ArrayList<>();

        for(int i = 0; i < 2*numBuckets; i++){
            buckets.add(null);
        }

        count=0;
        numBuckets = 2*numBuckets;

        for(int i = 0; i < temp.size(); i++){
            MapNode<K,V> t = temp.get(i);
            while(t!=null){
                insert(t.key, t.value);
                t = t.next;
            }
        }

    }

    //loadFactor
    public double loadFactor(){
        return (double)count/(double)numBuckets;
    }

    //insert
    public void insert(K key, V value){

        int bucketIndex = getBucketIndex(key);

        MapNode<K,V> head = buckets.get(bucketIndex);

        while(head!=null){
            //if the element is already there just update it
            if(head.key.equals(key)){
                head.value = value;
                return;
            }
            head = head.next;
        }

        //if the element is not there
        // insert at front of the LL
        head = buckets.get(bucketIndex);
        MapNode<K,V> newNode = new MapNode<>(key, value);
        newNode.next = head;
        buckets.set(bucketIndex, newNode);
        count++;

        double loadFactor = (double)count / (double)numBuckets;
        if(loadFactor>0.7){
            reHash();
        }

    }


    //remove
    public V removeKey(K key){

        int bucketIndex = getBucketIndex(key);
        MapNode<K,V> t = buckets.get(bucketIndex);
        MapNode<K,V> previous = null;
        while(t!=null){
            if(t.key.equals(key)){
                if(previous!=null){
                    previous.next = t.next;
                }else{
                    buckets.set(bucketIndex, t.next);
                }
                count--;
                return t.value;

                
            }
            previous = t;
            t = t.next;
            
        }
        return null;
    }
}
