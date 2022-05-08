package kruskal;

public class KruskalStructure {

    private final String next;
    private final String node;
    private final int value;

    public KruskalStructure(String next, String node, int value) {
        this.next = next;
        this.node = node;
        this.value = value;
    }

    public String getNext() {
        return next;
    }

    public String getNode() {
        return node;
    }

    public int getValue() {
        return value;
    }
}
