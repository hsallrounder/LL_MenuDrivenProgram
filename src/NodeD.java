public class NodeD {
    private int data;
    private NodeD next;
    private NodeD prev;

    public NodeD(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public NodeD getNext() {
        return next;
    }

    public void setNext(NodeD next) {
        this.next = next;
    }

    public NodeD getPrev() {
        return prev;
    }

    public void setPrev(NodeD prev) {
        this.prev = prev;
    }
}
