import java.util.InputMismatchException;

public interface LL<T> {
    default int getSize(){
        return 0;
    }
    default boolean isEmpty(){
        return true;
    }
    default void add(T val) {}
    default void insertAtBeginning(T val){}
    default void insert(int pos,T val) throws MyLLExceptions {}
    default void delete(T val) throws MyLLExceptions {}
    default void deleteAtIndex(int ind) throws MyLLExceptions {}
    default void display() throws MyLLExceptions {}
    default void displayRev() throws MyLLExceptions {}
}
