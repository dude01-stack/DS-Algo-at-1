/*

- By Krish Jani (KrishJani)

CREATING AND IMPLEMENTING A LINKED-LIST

My Linked List

Functions contained:
1.	 	add
2.	 	push
3.	 	insertAfter
4.	 	insertAtEnd
5.	 	delete
6.	 	deleteAt
7.	 	deleteAll
8.	 	length
9.	 	lengthbyRecursion
10.	search
11.	printSearchByRecursion
12.	getNode
13.	getNodeFromEnd
14.	reversePrint


CODE:

*/

package mylinkedlist;
import java.util.*;

public class MainLinkedList {
    
    Node head;
    
    void add(int data){
        Node toAdd=new Node(data);
        
        if(isEmpty()){
            head=toAdd;
            return;
        }
        
        Node temp=head;
        while(temp.next!=null)
            temp=temp.next;
        
        temp.next=toAdd;
    }
    
    
    void print(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }
    
    boolean isEmpty(){
        return head==null;
    }
    
    static class Node{
        int data;
        Node next;
        public Node(int data){
        this.data=data;
        next=null;
    }
    }
    
    
    void push(int data){
        Node newNode=new Node(data);
        
        newNode.next=head;
        
        head=newNode;
        
    }
    
    
    void insertAfter(Node prevNode, int data){
        if(prevNode==null){
            System.out.println("The given properties cannot be nulled");
            return;
        }
        Node newNode=new Node(data);
        
        newNode.next=prevNode.next;
        
        prevNode.next=newNode;
    }
    
    void insertAtEnd(int data){
        Node newNode=new Node(data);
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=newNode;
    }
    
    void delete(int key){
        
        Node temp=head;
        Node prev=null;
        
        if(temp!=null && temp.data==key)
            head=temp.next;
        
        
        while(temp!=null&& temp.data!=key){
            prev=temp;
            temp=temp.next;
        }

        if (temp == null) 
            return;
        
        prev.next=temp.next;
    }
    
    void deleteAt(int position){
        
        Node temp=head;
        Node prev=null;
        if(position<0)
            System.out.println("Position should be positive");
        if(position==0)
            head=temp.next;
        
        while(position>0){
            prev=temp;
            temp=temp.next;
            position--;
        }
        prev.next=temp.next;
        
    }
    
    void deleteAll(){
        
        head=null;
    }
    
    void length(){
        Node temp=head;
        int count=0;
        while(temp!=null){
            temp=temp.next;
            count++;
        }
        System.out.println(count);
    }
    
    
    int getCountByRecursion(Node node){
        if(node==null)
            return 0;
        
        return 1 + getCountByRecursion(node.next);
    }
    
    void lengthByRecursion(){
         System.out.println(getCountByRecursion(head));
    
    }
    
    void search(int key){
        
        Node temp=head;
        boolean x= false;
        while(temp!=null){
            if(temp.data==key)
                x= true;
            temp=temp.next;
        }
        System.out.println(x);
    }
    
    boolean searchByRecursion(Node head,int key){
        //temp=head;
        
        if(head==null)
            return false;
        
        if(head.data==key)
            return true;
        
        return searchByRecursion(head.next,key);
    }
    void printSearchByRecursion(Node head,int key){
        System.out.println(searchByRecursion(head,key));
    }
    
    
    void getNode(int n){
        if(n>=getCountByRecursion(head))
            System.out.println("ERROR: N must be less than the size of the array");
            
        Node temp=head;
        int i=0;
        while(temp!=null){
            if(i==n)
                System.out.println(temp.data);
            i++;
            temp=temp.next;
        }
    }
    
    void getNodeFromEnd(int n){
        Node temp=head;
        int len=0;
        while(temp!=null){
            temp=temp.next;
            len++;
        }
        temp=head;
        for(int i=1;i<len-n+1;i++){
            temp=temp.next;
        }
        System.out.println(temp.data);
    }
    
    void reverse(){
    
        Node prev=null;
        Node temp=head;
        Node next=null;
        
        while(temp!=null){
            
            next=temp.next;
            temp.next=prev;
            prev=temp;
            temp=next;
        }
        head=prev;
    }
    
    Node reverse(Node head, int k) 
    { 
       Node current = head; 
       Node next = null; 
       Node prev = null; 
         
       int count = 0; 
  
       /* Reverse first k nodes of linked list */
       while (count < k && current != null)  
       { 
           next = current.next; 
           current.next = prev; 
           prev = current; 
           current = next; 
           count++; 
       } 
  
       /* next is now a pointer to (k+1)th node  
          Recursively call for the list starting from current. 
          And make rest of the list as next of first node */
       if (next != null)  
          head.next = reverse(next, k); 
  
       // prev is now head of input list 
       return prev; 
    }        
    
    void reversePrint(int k){
        head=reverse(head,k);
        print();
    }
    
}




// Testing the code 

package mylinkedlist;
import java.util.*;
public class MyLinkedList {

    public static void main(String[] args) {
        
        MainLinkedList MyLL=new MainLinkedList();
        
        MyLL.add(1);
        MyLL.add(2);
        
        MyLL.print();
        MyLL.push(0);
        System.out.println();
        MyLL.print();
        System.out.println();
        MyLL.insertAfter(MyLL.head.next, 3);
        MyLL.print();
        System.out.println();
        MyLL.insertAtEnd(4);
        MyLL.print();
        MyLL.delete(3);
        System.out.println();
        MyLL.print();
        System.out.println();
        MyLL.deleteAt(2);
        MyLL.print();
        System.out.println();
        MyLL.deleteAll();
        
        for(int i=0;i<5;i++)
            MyLL.add(i+1);
        MyLL.print();
        
        System.out.println();
        MyLL.length();
        
        System.out.println();
        MyLL.lengthByRecursion();
        System.out.println();
        MyLL.search(1);
        MyLL.printSearchByRecursion(MyLL.head,7);
        MyLL.getNode(0);
        
        MyLL.getNodeFromEnd(2);
        MyLL.reverse();
        MyLL.print();
        System.out.println();
        
        MyLL.reversePrint(3);
    }   
    
}

