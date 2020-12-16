package Hashing;

import java.util.ArrayList;

public class OpenHash<K, V> {
    ArrayList<Node> hashTable = new ArrayList<Node>();
    int size = 0;

    public OpenHash(int size) {
        this.size = size;
        for (int i = 0; i < size; i++) {
            hashTable.add(null);
        }
    }

    int getHashed(K object) {
        return Math.abs(object.hashCode()) % size;
    }

    public Node insert(K key, V object) {
        Node<V> newNode = new Node<>();
        int index = getHashed(key);
        newNode.setObject(object);
        Node oldNode = hashTable.get(index);
        hashTable.set(index, newNode);
        if (oldNode != null)
            newNode.setNextNode(oldNode);
        return newNode;
    }

    public boolean remove(K key, V object) {
        Node firstNode = null;
        Node secondNode;
        int index = getHashed(key);
        secondNode = hashTable.get(index);
        while (secondNode != null && !secondNode.getObject().equals(object)) {
            firstNode = secondNode;
            secondNode = firstNode.getNextNode();
        }
        if (secondNode == null)
            return false;
        if (firstNode != null)
            firstNode.setNextNode(secondNode.getNextNode());
        else
            hashTable.set(index,secondNode.getNextNode());
        return true;
    }

    public Node search(K key) {
        Node node = null;
        node = hashTable.get(getHashed(key));
        while (node != null && !node.getObject().equals(key))
            node = node.getNextNode();
        return node;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            Node node = null;
            if (hashTable.get(i) == null) {
                continue;
            }
            else
                node = hashTable.get(i);
            stringBuilder.append(i+": ");
            stringBuilder.append(hashTable.get(i).getObject().toString());
            while (node.getNextNode() != null) {
                node = node.getNextNode();
                stringBuilder.append(" -> " + node.getObject().toString());
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}

