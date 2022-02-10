import org.w3c.dom.ranges.RangeException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main_Linked_List {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int l_ch=1;
        LL list=null;
        while(l_ch!=0) {
            System.out.println("-----Welecome to the main menu-----");
            System.out.println("1. SinglyLinkedList");
            System.out.println("2. DoublyLinkedList");
            System.out.println("3. CircularSinglyLinkedList");
            System.out.println("4. CircularDoublyLinkedList");
            System.out.println("0. Exit");
            System.out.print("\nEnter your choice: ");
            try {
                l_ch = sc.nextInt();
                if(!(l_ch>=0 && l_ch<=4)){
                    throw new InvalidRangeException("Value must in range [0,4].");
                }
            }
            catch (InputMismatchException | MyMenuException e){
                System.out.println(e.getMessage());
                continue;
            }
            if(l_ch==1){
                list=new SinglyLinkedList();
            }
            else if(l_ch==2){
                list=new DoublyLinkedList();
            }
            else if(l_ch==3){
                list=new CircularSinglyLinkedList();
            }
            else if(l_ch==4){
                list=new CircularDoublyLinkedList();
            }
            else if(l_ch==0){
                System.out.println("Exiting the Menu...");
                break;
            }
            int choice=1;
            while(choice!=0) {
                System.out.println("\n---Select the option you want to perfrom---");
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
                            throw new InvalidRangeException("Value must in range [0,7].");
                        }
                        else {
                            throw new InvalidRangeException("Value must in range [0,8].");
                        }
                    }
                }
                catch (InputMismatchException | MyMenuException e){
                    System.out.println(e.getMessage());
                }
                switch (choice){
                    case 1 -> {
                        System.out.print("Enter the value you want to insert: ");
                        list.add(sc.nextInt());
                        System.out.println("Value Inserted.");
                    }
                    case 2 -> {
                        System.out.print("Enter the value you want to insert: ");
                        list.insertAtBeginning(sc.nextInt());
                        System.out.println("Value Inserted.");
                    }
                    case 3 -> {
                        System.out.print("Enter the value you want to insert: ");
                        int val=sc.nextInt();
                        System.out.print("Enter the position[1:size] at which you want to insert: ");
                        int pos= sc.nextInt();
                        try {
                            list.insert(pos, val);
                            System.out.println("Value Inserted.");
                        }
                        catch (MyLLExceptions e){
                            System.out.println(e.getMessage());
                        }
                    }
                    case 4 -> System.out.println("Size: "+list.getSize());
                    case 5 -> {
                        System.out.print("Enter the element you want to delete: ");
                        try {
                            list.delete(sc.nextInt());
                            System.out.println("Value Deleted.");
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
                    case 0 -> System.out.println("Exiting the Function Menu...\n\n");
                }
            }
        }
    }
}
