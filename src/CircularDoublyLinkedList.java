public class CircularDoublyLinkedList<T> implements LL<T> {
    private int size;
    NodeD<T> head,tail;

    public CircularDoublyLinkedList() {
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public void add(T val){
        NodeD<T> newnode = new NodeD(val);
        if(isEmpty()){
            head = newnode;
        }
        else {
            NodeD<T> temp = tail;
            newnode.setPrev(temp);
            temp.setNext(newnode);
        }
        tail=newnode;
        head.setPrev(newnode);
        newnode.setNext(head);
        size++;
    }

    public void insertAtBeginning(T val){
        if(isEmpty()){
            add(val);
            return;
        }
        size++;
        NodeD<T> newnode=new NodeD(val);
        newnode.setNext(head);
        head.setPrev(newnode);
        head=newnode;
        tail.setNext(head);
        head.setPrev(tail);
    }

    public void insert(int pos,T val) throws MyLLExceptions {
        if(pos>size) {
            if(pos%size==0){
                pos=size;
            }
            else {
                pos = pos % size;
            }
        }
        if(isEmpty()){
            add(val);
        }
        else if(pos==1){
            insertAtBeginning(val);
        }
        else if(pos<1){
            throw new PostionMismatchException();
        }
        else {
            NodeD<T> newnode = new NodeD(val);
            NodeD<T> temp = head;
            for (int i=1;i<pos-1;i++) {
                temp = temp.getNext();
            }
            temp.getNext().setPrev(newnode);
            newnode.setNext(temp.getNext());
            newnode.setPrev(temp);
            temp.setNext(newnode);
            size++;
        }
    }

    public void delete(T val) throws MyLLExceptions {
        if(isEmpty()){
            throw new EmptyListException();
        }
        else{
            NodeD<T> temp=head;
            if(temp.getData()==val){
                head.getNext().setPrev(head.getPrev());
                head=head.getNext();
                size--;
                return;
            }
            while (temp.getNext()!=head && temp.getNext().getData()!=val){
                temp=temp.getNext();
            }
            if(temp.getNext()==head){
                throw new NoSuchValueException();
            }
            else{
                temp.getNext().getNext().setPrev(temp);
                temp.setNext(temp.getNext().getNext());
                size--;
            }
        }
    }

    public void deleteAtIndex(int ind) throws MyLLExceptions {
        if(ind>size) {
            if(ind%size==0){
                ind=size;
            }
            else {
                ind=ind % size;
            }
        }
        if(isEmpty()){
            throw new EmptyListException();
        }
        else {
            NodeD<T> temp=head;
            if(ind==0){
                head.getNext().setPrev(head.getPrev());
                head=head.getNext();
            }
            else {
                for (int i = 1; i < ind; i++) {
                    temp = temp.getNext();
                }
                temp.getNext().getNext().setPrev(temp);
                temp.setNext(temp.getNext().getNext());
            }
        }
        size--;
    }

    public void display() throws MyLLExceptions {
        if(isEmpty()){
            throw new EmptyListException();
        }
        else {
            NodeD<T> temp=head;
            while(temp.getNext()!=head){
                System.out.print(temp.getData()+"->");
                temp=temp.getNext();
            }
            System.out.println(temp.getData()+"->first-element");
        }
    }

    public void displayRev() throws MyLLExceptions {
        if(isEmpty()){
            throw new EmptyListException();
        }
        else {
            NodeD<T> temp=tail;
            while(temp.getPrev()!=tail){
                System.out.print(temp.getData()+"->");
                temp=temp.getPrev();
            }
            System.out.println(temp.getData()+"->last-element");
        }
    }
}