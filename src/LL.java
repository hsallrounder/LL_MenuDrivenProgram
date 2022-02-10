public interface LL {
    default int getSize(){
        return 0;
    }
    default boolean isEmpty(){
        return true;
    }
    default void add(int val){}
    default void insertAtBeginning(int val){}
    default void insert(int pos,int val) throws MyLLExceptions {}
    default void delete(int val) throws MyLLExceptions {}
    default void deleteAtIndex(int ind) throws MyLLExceptions {}
    default void display() throws MyLLExceptions {}
    default void displayRev() throws MyLLExceptions {}
}
