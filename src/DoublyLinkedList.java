public class DoublyLinkedList implements LL {
    private int size;
    NodeD head,tail;

    public DoublyLinkedList() {
        this.size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public void add(int val){
        NodeD newnode = new NodeD(val);
        if(isEmpty()){
            head = newnode;
        }
        else {
            NodeD temp = tail;
            newnode.setPrev(temp);
            temp.setNext(newnode);
        }
        tail=newnode;
        size++;
    }

    public void insertAtBeginning(int val){
        if(isEmpty()){
            add(val);
            return;
        }
        size++;
        NodeD newnode=new NodeD(val);
        newnode.setNext(head);
        head.setPrev(newnode);
        head=newnode;
    }

    public void insert(int pos,int val) throws PostionMismatchException {
        if(isEmpty() || pos>=size){
            add(val);
        }
        else if(pos==1){
            insertAtBeginning(val);
        }
        else if(pos<1){
            throw new PostionMismatchException();
        }
        else {
            NodeD newnode = new NodeD(val);
            NodeD temp = head;
            for (int i=1;i<pos-1;i++) {
                temp = temp.getNext();
            }
            newnode.setNext(temp.getNext());
            temp.getNext().setPrev(newnode.getNext().getPrev());
            temp.setNext(newnode);
            newnode.setPrev(temp);
            size++;
        }
    }

    public void delete(int val) throws MyLLExceptions {
        if(isEmpty()){
            throw new EmptyListException();
        }
        else{
            NodeD temp=head;
            if(temp.getData()==val){
                head=head.getNext();
                size--;
                return;
            }
            while (temp.getNext()!=null && temp.getNext().getData()!=val){
                temp=temp.getNext();
            }
            if(temp.getNext()==null){
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
        if(isEmpty()){
            throw new EmptyListException();
        }
        else if(ind>=size){
            throw new EmptyListException();
        }
        else {
            NodeD temp=head;
            if(ind==0){
                head=head.getNext();
                head.setPrev(null);
            }
            else {
                for (int i = 1; i < ind; i++) {
                    temp = temp.getNext();
                }
                temp.getNext().getNext().setPrev(temp);
                temp.setNext(temp.getNext().getNext());
            }
            size--;
        }
    }

    public void display() throws MyLLExceptions {
        if(isEmpty()){
            throw new EmptyListException();
        }
        else {
            NodeD temp=head;
            while(temp!=null){
                System.out.print(temp.getData()+"->");
                temp=temp.getNext();
            }
            System.out.println("null");
        }
    }

    public void displayRev() throws MyLLExceptions {
        if(isEmpty()){
            throw new EmptyListException();
        }
        else {
            NodeD temp=tail;
            while(temp!=null){
                System.out.print(temp.getData()+"->");
                temp=temp.getPrev();
            }
            System.out.println("null");
        }
    }
}