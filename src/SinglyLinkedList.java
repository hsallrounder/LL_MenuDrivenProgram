public class SinglyLinkedList implements LL {
    private int size;
    NodeS head;

    public SinglyLinkedList() {
        this.size=0;
    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty(){
        return this.size==0;
    }

    public void add(int val){
        NodeS newnode = new NodeS(val);
        if(isEmpty()){
            head = newnode;
        }
        else {
            NodeS temp = head;
            while(temp.getNext()!=null) {
                temp = temp.getNext();
            }
            temp.setNext(newnode);
        }
        size++;
    }

    public void insertAtBeginning(int val){
        if(isEmpty()){
            add(val);
            return;
        }
        size++;
        NodeS newnode=new NodeS(val);
        newnode.setNext(head);
        head=newnode;
    }

    public void insert(int pos,int val) throws MyLLExceptions {
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
            NodeS newnode = new NodeS(val);
            NodeS temp = head;
            for (int i=1;i<pos-1;i++) {
                temp = temp.getNext();
            }
            newnode.setNext(temp.getNext());
            temp.setNext(newnode);
            size++;
        }
    }

    public void delete(int val) throws MyLLExceptions {
        if(isEmpty()){
            throw new EmptyListException();
        }
        else{
            NodeS temp=head;
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
            NodeS temp=head;
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
            NodeS temp=head;
            while(temp!=null){
                System.out.print(temp.getData()+"->");
                temp=temp.getNext();
            }
            System.out.println("null");
        }
    }
}