package Hashing;

import java.nio.file.Path;
import java.util.ArrayList;

public class ClosedHash<K, V> {
    ArrayList<Pair> hashTable = new ArrayList<Pair>();
    int size = 0;

    public ClosedHash(int size) {
        this.size = size;
        for (int i = 0; i < size; i++) {
            hashTable.add(null);
        }
    }

    int findSlot(K key) {
        int i = 0;
        int j = getHashed(key) % size;
        // search until we either find the key, or find an empty slot.
        while (i < size) {
            if (hashTable.get((j+i)%size) != null) {
                if (!hashTable.get((j+i)%size).getKey().equals(key))
                    i++;
                else return (j+i)%size;
            }
            else return (j+i)%size;

        }
        return - 1;
    }

    int getHashed(K key) {
        return Math.abs(key.hashCode()) % size;
    }

    public boolean insert(K key, V object){
        int i = findSlot(key);
        if (i == -1)
            return false;
        if (hashTable.get(i) != null)
            hashTable.get(i).setValue(object);
        else
            hashTable.set(i, new Pair(key, object));
        return true;
    }

    public boolean remove(K key){
        int i = findSlot(key);
        if(i == -1)
            return false;
        if (hashTable.get(i) == null)
            return false;
        int j = i;
        boolean unmark = true;
        while (true) {
            if (unmark)
                hashTable.set(i, null);
            j = (j+1) % size;
            if (hashTable.get(j) == null)
                break;
            int k = getHashed((K)hashTable.get(j).getKey()) % size;
            if ((i<=j) ? ((i<k)&&(k<=j)) : ((i<k)||(k<=j))) {
                unmark = false;
                continue;
            }
            else
                unmark = true;
            hashTable.set(i, hashTable.get(j));
            i = j;
        }
        return true;
    }

    public V search(K key){
        int i = findSlot(key);

        if (i == -1)
            return null;

        return (V)hashTable.get(i).getValue();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        boolean first = true;
        for (int i = 0; i < size; i++) {
            if (hashTable.get(i) != null) {
                if (!first)
                    stringBuilder.append("\n");
                Pair pair = hashTable.get(i);
                stringBuilder.append(i+" K:" + pair.getKey() + " V:" + pair.getValue());
                first = false;
            }
        }
        return stringBuilder.toString();
    }

    class Pair<K,V> {
        K key = null;
        V value = null;

        public Pair (K key, V value) {
            setKey(key);
            setValue(value);
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}
