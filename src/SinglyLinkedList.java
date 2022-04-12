public class SinglyLinkedList<T> implements LL<T> {
    private int size;
    NodeS<T> head;

    public SinglyLinkedList() {
        this.size=0;
    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty(){
        return this.size==0;
    }

    public void add(T val){
        NodeS<T> newnode = new NodeS(val);
        if(isEmpty()){
            head = newnode;
        }
        else {
            NodeS<T> temp = head;
            while(temp.getNext()!=null) {
                temp = temp.getNext();
            }
            temp.setNext(newnode);
        }
        size++;
    }

    public void insertAtBeginning(T val){
        if(isEmpty()){
            add(val);
            return;
        }
        size++;
        NodeS<T> newnode=new NodeS(val);
        newnode.setNext(head);
        head=newnode;
    }

    public void insert(int pos,T val) throws MyLLExceptions {
        size++;
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
                return;
            }
            while (temp.getNext()!=null && temp.getNext().getData()!=val){
                temp=temp.getNext();
            }
            if(temp.getNext()==null){
                throw new NoSuchValueException();
            }
            else{
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
            throw new InvalidInputException();
        }
        else {
            NodeS<T> temp=head;
            if(ind==0){
                head=head.getNext();
            }
            else {
                for (int i = 1; i<ind; i++) {
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
            while(temp!=null){
                System.out.print(temp.getData()+"->");
                temp=temp.getNext();
            }
            System.out.println("null");
        }
    }
}