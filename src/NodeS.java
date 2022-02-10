public class NodeS {
    private int data;
    private NodeS next;

    public NodeS(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public NodeS getNext() {
        return next;
    }

    public void setNext(NodeS next) {
        this.next = next;
    }
}
