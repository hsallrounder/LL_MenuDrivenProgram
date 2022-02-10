public class CircularSinglyLinkedList implements LL {
    private int size;
    NodeS head;

    public CircularSinglyLinkedList() {
        this.size=0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public void add(int val){
        NodeS newnode = new NodeS(val);
        if(isEmpty()){
            head = newnode;
        }
        else {
            NodeS temp = head;
            while(temp.getNext()!=head) {
                temp = temp.getNext();
            }
            temp.setNext(newnode);
        }
        newnode.setNext(head);
        size++;
    }

    public void insertAtBeginning(int val){
        if(isEmpty()){
            add(val);
            return;
        }
        size++;
        NodeS newnode=new NodeS(val);
        NodeS temp=head;
        while(temp.getNext()!=head){
            temp=temp.getNext();
        }
        temp.setNext(newnode);
        newnode.setNext(head);
        head=newnode;
    }

    public void insert(int pos,int val) throws MyLLExceptions {
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
            NodeS temp=head;
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
            NodeS temp=head;
            while(temp.getNext()!=head){
                System.out.print(temp.getData()+"->");
                temp=temp.getNext();
            }
            System.out.println(temp.getData()+"->first-element");
        }
    }
}