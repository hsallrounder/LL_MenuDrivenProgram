public class CircularSinglyLinkedList<T> implements LL<T> {
    private int size;
    NodeS<T> head;

    public CircularSinglyLinkedList() {
        this.size=0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public void add(T val){
        NodeS<T> newnode = new NodeS(val);
        if(isEmpty()){
            head = newnode;
        }
        else {
            NodeS<T> temp = head;
            while(temp.getNext()!=head) {
                temp = temp.getNext();
            }
            temp.setNext(newnode);
        }
        newnode.setNext(head);
        size++;
    }

    public void insertAtBeginning(T val){
        if(isEmpty()){
            add(val);
            return;
        }
        size++;
        NodeS<T> newnode=new NodeS(val);
        NodeS<T> temp=head;
        while(temp.getNext()!=head){
            temp=temp.getNext();
        }
        temp.setNext(newnode);
        newnode.setNext(head);
        head=newnode;
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
            NodeS<T> newnode = new NodeS(val);
            NodeS<T> temp = head;
            for (int i=1;i<pos-1;i++) {
                temp = temp.getNext();
            }
            newnode.setNext(temp.getNext());
            temp.setNext(newnode);
            size++;
        }
    }

    public void delete(T val) throws MyLLExceptions {
        if(isEmpty()){
            throw new EmptyListException();
        }
        else{
            NodeS<T> temp=head;
            if(temp.getData()==val){
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
            NodeS<T> temp=head;
            if(ind==0){
                head=head.getNext();
            }
            else {
                for (int i = 1; i < ind; i++) {
                    temp = temp.getNext();
                }
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
            NodeS<T> temp=head;
            while(temp.getNext()!=head){
                System.out.print(temp.getData()+"->");
                temp=temp.getNext();
            }
            System.out.println(temp.getData()+"->first-element");
        }
    }
}