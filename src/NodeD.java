public class NodeD<T> {
    private T data;
    private NodeD<T> next;
    private NodeD<T> prev;

    public NodeD(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public NodeD<T> getNext() {
        return next;
    }

    public void setNext(NodeD<T> next) {
        this.next = next;
    }

    public NodeD<T> getPrev() {
        return prev;
    }

    public void setPrev(NodeD<T> prev) {
        this.prev = prev;
    }
}
