package Hashing;

class Node<V> {
    private V object = null;
    private Node nextNode = null;

    public V getObject() {
        return object;
    }

    public void setObject(V object) {
        this.object = object;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
}
