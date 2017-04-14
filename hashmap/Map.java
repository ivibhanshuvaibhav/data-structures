package hashmap;

import java.util.ArrayList;

public class Map<K, V> {

    private ArrayList<HashNode<K, V>> bucketArray;
    private int numBuckets;
    private int size;

    public Map() {
        bucketArray = new ArrayList<>();
        numBuckets = 10;
        size = 0;

        for (int i = 0; i < numBuckets; i++){
            bucketArray.add(null);
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int getBucketIndex(K key){
        int hashCode = key.hashCode();
        int index = hashCode % numBuckets;
        System.out.println("Index " + index);
        return index;
    }

    public void put(K key, V value){
        System.out.println("Key " + key);
        int bucketIndex = getBucketIndex(key);
        HashNode<K, V> head = bucketArray.get(bucketIndex);
        while (head != null){
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }
        size++;
        head = bucketArray.get(bucketIndex);
        HashNode<K, V> newNode = new HashNode<>(key, value);
        newNode.next = head;
        bucketArray.set(bucketIndex, newNode);
        double loadingFactor = (double) size()/numBuckets;

        if (loadingFactor >= 0.75){
            ArrayList<HashNode<K, V>> temp = bucketArray;
            bucketArray = new ArrayList<>();
            numBuckets = 2 * numBuckets;
            size = 0;
            for (int i = 0; i < numBuckets; i++){
                bucketArray.add(null);
            }

            for (HashNode<K, V> headNode : temp){
                while (headNode != null){
                    put(headNode.key, headNode.value);
                    headNode = headNode.next;
                }
            }
        }
    }

    public V get(K key){
        int bucketIndex = getBucketIndex(key);
        HashNode<K, V> head = bucketArray.get(bucketIndex);

        while (head != null){
            if (head.key.equals(key)){
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    public V remove(K key){
        int bucketIndex = getBucketIndex(key);
        HashNode<K, V> head = bucketArray.get(bucketIndex);
        HashNode<K, V> prev = null;

        if (head == null){
            return null;
        }

        while (head != null){
            if (head.key.equals(key)){
                break;
            }
            prev = head;
            head = head.next;
        }

        size--;

        if (prev != null){
            prev.next = head.next;
        } else {
            bucketArray.set(bucketIndex, head.next);
        }

        return head.value;
    }

    public static void main(String[] args) {

        Map<String, Integer> map = new Map();

        System.out.println(map.size());

        map.put("a",10);
        map.put("b",20);
        map.put("c",30);
        map.put("d",40);
        map.put("e",50);
        map.put("f",60);
        map.put("g",70);
        map.put("h",80);
        map.put("i",90);
        map.put("j",100);

        System.out.println("Size " + map.size());
        System.out.println(map.remove("h"));
        System.out.println("Size " + map.size());
        System.out.println(map.get("d"));



    }

}
