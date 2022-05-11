package radix;

public class SimpleList {

    private int value;
    private SimpleList position;
    private SimpleList subList;

    public SimpleList(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public SimpleList getPosition() {
        return position;
    }

    public void setPosition(SimpleList position) {
        this.position = position;
    }

    public SimpleList getSubList() {
        return subList;
    }

    public void setSubList(SimpleList subList) {
        this.subList = subList;
    }
}
