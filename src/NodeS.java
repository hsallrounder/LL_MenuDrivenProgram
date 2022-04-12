public class NodeS<T> {
    private T data;
    private NodeS<T> next;

    public NodeS(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public NodeS<T> getNext() {
        return next;
    }

    public void setNext(NodeS<T> next) {
        this.next = next;
    }
}
