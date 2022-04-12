import java.util.InputMismatchException;
import java.util.Scanner;

public class Main_Linked_List {
    LL listType_Int(int ltype){
        if(ltype==1) return new SinglyLinkedList<Integer>();
        if(ltype==2) return new DoublyLinkedList<Integer>();
        if(ltype==3) return new CircularSinglyLinkedList<Integer>();
        return new CircularDoublyLinkedList<Integer>();
    }
    LL listType_Bool(int ltype){
        if(ltype==1) return new SinglyLinkedList<Boolean>();
        if(ltype==2) return new DoublyLinkedList<Boolean>();
        if(ltype==3) return new CircularSinglyLinkedList<Boolean>();
        return new CircularDoublyLinkedList<Boolean>();
    }
    LL listType_Char(int ltype){
        if(ltype==1) return new SinglyLinkedList<Character>();
        if(ltype==2) return new DoublyLinkedList<Character>();
        if(ltype==3) return new CircularSinglyLinkedList<Character>();
        return new CircularDoublyLinkedList<Character>();
    }
    LL listType_Doub(int ltype){
        if(ltype==1) return new SinglyLinkedList<Double>();
        if(ltype==2) return new DoublyLinkedList<Double>();
        if(ltype==3) return new CircularSinglyLinkedList<Double>();
        return new CircularDoublyLinkedList<Double>();
    }
    LL listType_Str(int ltype){
        if(ltype==1) return new SinglyLinkedList<String>();
        if(ltype==2) return new DoublyLinkedList<String>();
        if(ltype==3) return new CircularSinglyLinkedList<String>();
        return new CircularDoublyLinkedList<String>();
    }
    LL listType_Byte(int ltype){
        if(ltype==1) return new SinglyLinkedList<Byte>();
        if(ltype==2) return new DoublyLinkedList<Byte>();
        if(ltype==3) return new CircularSinglyLinkedList<Byte>();
        return new CircularDoublyLinkedList<Byte>();
    }
    LL listType_Long(int ltype){
        if(ltype==1) return new SinglyLinkedList<Long>();
        if(ltype==2) return new DoublyLinkedList<Long>();
        if(ltype==3) return new CircularSinglyLinkedList<Long>();
        return new CircularDoublyLinkedList<Long>();
    }
    LL listType_Short(int ltype){
        if(ltype==1) return new SinglyLinkedList<Short>();
        if(ltype==2) return new DoublyLinkedList<Short>();
        if(ltype==3) return new CircularSinglyLinkedList<Short>();
        return new CircularDoublyLinkedList<Short>();
    }
    LL listType_Float(int ltype){
        if(ltype==1) return new SinglyLinkedList<Float>();
        if(ltype==2) return new DoublyLinkedList<Float>();
        if(ltype==3) return new CircularSinglyLinkedList<Float>();
        return new CircularDoublyLinkedList<Float>();
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int l_ch=1;
        LL list=null;
        while(l_ch!=0) {
            System.out.println("-----Welcome to the main menu-----");
            System.out.println("1. SinglyLinkedList");
            System.out.println("2. DoublyLinkedList");
            System.out.println("3. CircularSinglyLinkedList");
            System.out.println("4. CircularDoublyLinkedList");
            System.out.println("0. Exit");
            System.out.print("\nEnter your choice: ");
            try {
                l_ch = sc.nextInt();
                if(!(l_ch>=0 && l_ch<=4)){
                    throw new InvalidRangeException("Value must in Integer range [0,4].\n");
                }
            }
            catch (InputMismatchException e){
                System.out.println("Value must in Integer range [0,4].\n");
                sc.next();
                continue;
            }
            catch (MyMenuException e){
                System.out.println(e.getMessage());
                continue;
            }
            if(l_ch==0) {
                System.out.println("Exiting the Menu...");
                break;
            }
            Main_Linked_List obj = new Main_Linked_List();
            System.out.println("\n1. Integer Data Type List");
            System.out.println("2. Character Data Type List");
            System.out.println("3. Boolean Data Type List");
            System.out.println("4. String Data Type List");
            System.out.println("5. Byte Data Type List");
            System.out.println("6. Short Data Type List");
            System.out.println("7. Long Data Type List");
            System.out.println("8. Float Data List");
            System.out.println("9. Double Data Type List");
            System.out.print("\nEnter your choice: ");
            int dtype=1;
            try{
                dtype=sc.nextInt();
                if(!(dtype>=1 && dtype<=9)){
                    throw new InvalidRangeException("Value must in Integer range [1,9].");
                }
            }
            catch (InputMismatchException e){
                System.out.println("Value must in Integer range [1,9].");
                sc.next();
		        continue;
            }
            catch (MyMenuException e){
                System.out.println(e.getMessage());
            }
            if(dtype==1){
                list=obj.listType_Int(l_ch);
            }
            else if(dtype==2){
                list=obj.listType_Char(l_ch);
            }
            else if(dtype==3){
                list=obj.listType_Bool(l_ch);
            }
            else if(dtype==4){
                list=obj.listType_Str(l_ch);
            }
            else if (dtype==5){
                list=obj.listType_Byte(l_ch);
            }
            else if(dtype==6){
                list=obj.listType_Short(l_ch);
            }
            else if(dtype==7){
                list=obj.listType_Long(l_ch);
            }
            else if(dtype==8){
                list=obj.listType_Float(l_ch);
            }
            else if(dtype==9){
                list=obj.listType_Doub(l_ch);
            }
            int choice=1;
            while(choice!=0) {
                System.out.println("\n---Select the option you want to perform---");
                System.out.println("1. Add an element.");
                System.out.println("2. Insert the value at First Position.");
                System.out.println("3. Insert the value at specific position.");
                System.out.println("4. Print the size of list.");
                System.out.println("5. Delete an element.");
                System.out.println("6. Delete element at specific index.");
                System.out.println("7. Print the list.");
                if(l_ch==2 || l_ch==4){
                    System.out.println("8. Print the list in reverse order.");
                }
                System.out.println("0. Exit");
                System.out.print("\nEnter your choice: ");
                try {
                    choice = sc.nextInt();
                    if(!(choice>=0 && choice<=8)){
                        if(l_ch==1 || l_ch==3){
                            throw new InvalidRangeException("Value must in Integer range [0,7].");
                        }
                        else {
                            throw new InvalidRangeException("Value must in Integer range [0,8].");
                        }
                    }
                }
                catch (InputMismatchException e){
                    if(l_ch==1 || l_ch==3) {
                        System.out.println("Value must in Integer range [0,7].");
                    }
                    else {
                        System.out.println("Value must in Integer range [0,8].");
                    }
                    sc.next();
                    continue;
                }
                catch (MyMenuException e){
                    System.out.println(e.getMessage());
                }
                switch (choice){
                    case 1 -> {
                        System.out.print("Enter the value you want to insert: ");
                        try {
                            switch (dtype){
                                case 1 -> list.add(sc.nextInt());
                                case 2 -> {
                                    String val=sc.next();
                                    char temp=val.charAt(0);
                                    if(!Character.isAlphabetic(temp)) {
                                        System.out.println("Value must be in the data type you have selected.");
                                        continue;
                                    }
                                    else list.add(temp);
                                }
                                case 3 -> list.add(sc.nextBoolean());
                                case 4 -> list.add(sc.next());
                                case 5 -> list.add(sc.nextByte());
                                case 6 -> list.add(sc.nextShort());
                                case 7 -> list.add(sc.nextLong());
                                case 8 -> list.add(sc.nextFloat());
                                case 9 -> list.add(sc.nextDouble());
                            }
                            System.out.println("Value Inserted.");
                        }
                        catch (InputMismatchException e){
                            System.out.println("Value must be in the data type you have selected.");
                            sc.next();
                        }
                    }
                    case 2 -> {
                        System.out.print("Enter the value you want to insert: ");
                        try {
                            switch (dtype) {
                                case 1 -> list.insertAtBeginning(sc.nextInt());
                                case 2 -> {
                                    String val = sc.next();
                                    char temp = val.charAt(0);
                                    if (!Character.isAlphabetic(temp)) {
                                        System.out.println("Value must be in the data type you have selected.");
                                        continue;
                                    }
                                    else list.insertAtBeginning(temp);
                                }
                                case 3 -> list.insertAtBeginning(sc.nextBoolean());
                                case 4 -> list.insertAtBeginning(sc.next());
                                case 5 -> list.insertAtBeginning(sc.nextByte());
                                case 6 -> list.insertAtBeginning(sc.nextShort());
                                case 7 -> list.insertAtBeginning(sc.nextLong());
                                case 8 -> list.insertAtBeginning(sc.nextFloat());
                                case 9 -> list.insertAtBeginning(sc.nextDouble());
                            }
                            System.out.println("Value Inserted.");
                        }
                        catch (InputMismatchException e){
                            System.out.println("Value must be in the data type you have selected.");
                            sc.next();
                        }
                    }
                    case 3 -> {
                        System.out.print("Enter the position[1:size] at which you want to insert: ");
                        int pos= sc.nextInt();
                        System.out.print("Enter the value you want to insert: ");
                        try {
                            switch (dtype){
                                case 1 -> list.insert(pos,sc.nextInt());
                                case 2 -> {
                                    String val=sc.next();
                                    char temp=val.charAt(0);
                                    if(!Character.isAlphabetic(temp)){
                                        System.out.println("Value must be in the data type you have selected.");
                                        continue;
                                    }
                                    else list.insert(pos,temp);
                                }
                                case 3 -> list.insert(pos,sc.nextBoolean());
                                case 4 -> list.insert(pos,sc.next());
                                case 5 -> list.insert(pos,sc.nextByte());
                                case 6 -> list.insert(pos,sc.nextShort());
                                case 7 -> list.insert(pos,sc.nextLong());
                                case 8 -> list.insert(pos,sc.nextFloat());
                                case 9 -> list.insert(pos,sc.nextDouble());
                            }
                            System.out.println("Value Inserted.");
                        }
                        catch (InputMismatchException e){
                            System.out.println("Value must be in the data type you have selected.");
                            sc.next();
                        }
                        catch (MyLLExceptions e){
                            System.out.println(e.getMessage());
                        }
                    }
                    case 4 -> System.out.println("Size: "+list.getSize());
                    case 5 -> {
                        System.out.print("Enter the element you want to delete: ");
                        try {
                            switch (dtype){
                                case 1 -> list.delete(sc.nextInt());
                                case 2 -> {
                                    String val=sc.next();
                                    char temp=val.charAt(0);
                                    if(!Character.isAlphabetic(temp)){
                                        System.out.println("Value must be in the data type you have selected.");
                                        continue;
                                    }
                                    else list.delete(temp);
                                }
                                case 3 -> list.delete(sc.nextBoolean());
                                case 4 -> list.delete(sc.next());
                                case 5 -> list.delete(sc.nextByte());
                                case 6 -> list.delete(sc.nextShort());
                                case 7 -> list.delete(sc.nextLong());
                                case 8 -> list.delete(sc.nextFloat());
                                case 9 -> list.delete(sc.nextDouble());
                            }
                            System.out.println("Value Deleted.");
                        }
                        catch (InputMismatchException e){
                            System.out.println("Value must be in the data type you have selected.");
                            sc.next();
                        }
                        catch (MyLLExceptions e){
                            System.out.println(e.getMessage());
                        }
                    }
                    case 6 -> {
                        System.out.print("Enter the index[0:size) of element you want to delete: ");
                        int ind= sc.nextInt();
                        try {
                            list.deleteAtIndex(ind);
                            System.out.println("Element Deleted.");
                        }
                        catch (MyLLExceptions e){
                            System.out.println(e.getMessage());
                        }
                    }
                    case 7 -> {
                        try{
                            list.display();
                        }
                        catch (MyLLExceptions e){
                            System.out.println(e.getMessage());
                        }
                    }
                    case 8 -> {
                        if(l_ch==1 || l_ch==3){
                            System.out.println("Invalid Input.");
                        }
                        else {
                            try {
                                list.displayRev();
                            }
                            catch (MyLLExceptions e){
                                System.out.println(e.getMessage());
                            }
                        }
                    }
                    case 0 -> System.out.println("Returning to the Main Menu...\n\n");
                }
            }
        }
    }
}
