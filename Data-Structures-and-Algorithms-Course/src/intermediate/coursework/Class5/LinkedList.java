package intermediate.coursework.Class5;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author zouMicrosoftSurface
 */
public class LinkedList<E> {
    Node<E> head;

    public LinkedList() {
        head = null;
    }

    /*
    1. one important error: preN=tmpN.next ==> preN.next=tmpN.next in remove
    2. insertAtIndex ==> insertAsIndex
    3. test for negative value
    4. test different cases, how to?
    5. clear and java garbage collection.

    */
    public static void main(String[] args) {
        LinkedList<String> ll = new LinkedList();
        System.out.println(ll);
        System.out.println("size=" + ll.size());

        //test different insert cases.
        Node<String> n = new Node("Xukai Zou");
        //ll.append(n); //apend to an empty list is to insert into head.
        ll.insertAtHead(n);
        System.out.println(ll);
        //System.out.println(ll.first());
        n = new Node("Bill Bill");
        ll.insertAtHead(n);
        System.out.println(ll);
        n = new Node("George Washingston");
        ll.append(n);
        System.out.println(ll);

//        System.out.println(ll.size());
        n = new Node("Lincoln Scott");
        ll.insertAsIndex(n, 0);  //insert as element with index 0 is to insert at head
        System.out.println(ll);


        n = new Node("Tom Piece");
        ll.insertAsIndex(n, 5);  //insert as element with index 5 is to discard
        System.out.println(ll);


        ll.insertAsIndex(n, 4);  //but insert as element with index 4 is to insert at the end
        System.out.println(ll);


        //test different cases for remove
        String res = ll.removeLast();  //
        System.out.println(res);
        System.out.println(ll);

        res = ll.remove(4); //out of range
        System.out.println(res);
        System.out.println(ll);
        res = ll.remove(-1); //out of range
        System.out.println(res);
        System.out.println(ll);
        res = ll.remove(2); //remove node with index 2, i.e., the third element
        System.out.println(res);
        System.out.println(ll);

        n = new Node(res);
        ll.insertAsIndex(n, 2); //insert back for further test
        System.out.println(ll);

        res = ll.remove(3); //remove node with index 3, i.e., the forth element or last element
        System.out.println(res);
        System.out.println(ll);


        n = new Node(res);
        ll.insertAsIndex(n, 3); //insert back for further test
        System.out.println(ll);


        res = ll.remove(0);  //removing 0 is to remove the first, i.e., head
        System.out.println(res);
        System.out.println(ll);

        n = new Node(res);
        ll.insertAsIndex(n, 0); //insert back for further test
        System.out.println(ll);

        res = ll.removeFirst();
        System.out.println(res);
        System.out.println(ll);

        n = new Node(res);
        ll.insertAsIndex(n, 0); //insert back for further test
        System.out.println(ll);

        res = ll.removeLast();  //removing 0 is to remove the first, i.e., head
        System.out.println(res);
        System.out.println(ll);

        n = new Node(res);
        ll.insertAsIndex(n, 3); //insert back for further test
        System.out.println(ll);

        //test remove when the list is empty
        ll.clear();
        System.out.println(ll);

        res = ll.removeFirst();
        System.out.println(res);
        System.out.println(ll);

        res = ll.removeLast();
        System.out.println(res);
        System.out.println(ll);

        res = ll.remove(1);  //remove an element with any index is to do nothing
        System.out.println(res);
        System.out.println(ll);

    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        int size = 0;
        Node tmpN = head;
        while (tmpN != null) {
            size++;
            tmpN = tmpN.next;
        }
        return size;
    }

    public E first() {
        if (head == null) //empty
            return null;
        else
            return head.element;
    }

    public E last() {
        Node tmpN = head;
        if (head == null) //empty list
            return null;
        while (tmpN.next != null)
            tmpN = tmpN.next;
        return (E) (tmpN.element);

        /*     if(tail==null)
            return null;
        else
            return tail.element;
        */
    }

    public E getElement(int ind) {
        //ind >=0;  0: first emelement
        int ti = 0;
        //   if (size <ind+1)
        //     return null;
        Node tmpN = head;
        while (tmpN != null && ti < ind) {
            tmpN = tmpN.next;
            ti++;
        }
        if (tmpN == null)
            return null;
        else
            return (E) (tmpN.element);
    }

    //add more methods
    public void insertAtHead(Node n) {
        if (head == null) {//initially an empty DemoLinkedList
            head = n;
            // tail=n;
        } else {
            n.next = head;
            head = n;
        }
        // size++;
    }

    //
    public void insertAtTail(Node n) {
        if (head == null) {//initial empty
            head = n;
            /// n.next=null;
            return;
        }
        Node tmpN = head;
        //go to the lase
        while (tmpN.next != null)
            tmpN = tmpN.next;
        tmpN.next = n;
        //n.next=null;
        // size++;
    }

    public void append(Node n) {
        insertAtTail(n);
    }

    public void insertAtIndex(Node n, int ind) {
        //ind>=0; insert after the ind.

        if (head == null) { //empty{
            if (ind == 0) {
                head = n;
                return;
            } else// do nothing, not insert
                return;
        }

        Node tmpN = head;//point to the first element
        int ti = 0;
        while (tmpN != null && ti < ind) { // continue until reaching node ind
            ti++;
            tmpN = tmpN.next;
        }
        if (tmpN != null) {//
            n.next = tmpN.next;
            tmpN.next = n;

        }//else //discard it, do nothing.
    }

    public void insertAsIndex(Node n, int ind) {
        //ind>=0; insert as node ind.
        if (ind < 0) {
            System.out.println("The provided argument " + ind + " is negative, which is wrong!");
            return;
        }
        if (ind == 0) {
            insertAtHead(n);
            return;
        }
        Node tmpN = head;//point to the first element
        int ti = 0;
        while (tmpN != null && ti < ind - 1) { // continue until reaching node ind
            ti++;
            tmpN = tmpN.next;
        }
        if (tmpN != null) {//
            n.next = tmpN.next;
            tmpN.next = n;

        }//else //discard it, do nothing.
    }

    public E removeFirst() {
        if (head == null)
            return null;
        else {
            Node tmpN = head;
            head = head.next;
            //  size--;
            return (E) (tmpN.element);
        }
    }

    public E remove(int ind) {
        //ind>=0; remove the element with index ind (index begins from 0)
        if (ind < 0) {
            System.out.println("The provided argument " + ind + " is negative, which is wrong");
            return null;
        }
        Node tmpN = head;


        Node preN = null;
        int ti = 0;
        while (tmpN != null && ti < ind) {
            preN = tmpN;
            tmpN = tmpN.next;
            ti++;
        }

        if (tmpN != null) {
            if (preN != null) {
                preN.next = tmpN.next;  //changed from preN=tmpN.next;
                return (E) (tmpN.element);
            } else {
                head = head.next;
                return (E) (tmpN.element);
            }
        } else
            return null;
    }

    public E removeLast() {
        // int size=size();
        //if(size>0)
        //    return remove(size-1);
        //else
        //    return null;

        Node tmpN = head;
        if (head == null)  //empty list
            return null;
        else if (tmpN.next == null) { //just one element, removing it to , become an empty list
            head = null;
            return (E) (tmpN.element);
        }
        Node preN = tmpN;
        tmpN = tmpN.next;
        while (tmpN.next != null) {
            preN = tmpN;
            tmpN = tmpN.next;

        }
        preN.next = null;
        return (E) (tmpN.element);
    }

    public void clear() {
        head = null;  //set head to null to make it an empty list.  Notes: the original list was lost, and which will be automatically collected by Java Garbage collection engine
    }

    public String toString() {
        String ts = "";
        // int size=size();
        Node tmpN = head;
        while (tmpN != null) {
            ts += tmpN.element + " ; ";
            tmpN = tmpN.next;
        }
        return ts;
    }


}

class Node<E> {
    E element;
    Node<E> next;

    public Node(E element) {
        this.element = element;
        next = null;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node newNode) {
        next = newNode;
    }

    public E getValue() {
        return element;
    }
}

/*


public class DemoLinkedList<E> {
    Node<E> head;
    Node<E>tail;
    private int size=0;
    public DemoLinkedList(){
        head=null;
        tail=null;
        size=0;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public int size(){
        return size;
    }
    public E first(){
        if(head==null)
            return null;
        else
            return head.element;
    }
    public E last(){
        if(tail==null)
            return null;
        else
            return tail.element;
    }
    public E getElement(int ind){
        //ind >=0;
        int ti=0;
        if (size <ind+1)
            return null;
        Node tmpN=head;
        while(ti<ind){
            tmpN=tmpN.next;
            ti++;
        }
        return (E)(tmpN.element);
    }
    //add more methods
    public void insertAtHead(Node n){
        if (head==null){//initially an empty DemoLinkedList
            head=n;
            tail=n;
        }else{
            n.next=head;
            head=n;
        }
        size++;
    }
   //
    public void insertAtTail(Node n){
        if (tail==null){
            head=n;
            tail=n;
        }else{
            tail.next=n;
            tail=n;
        }
        size++;
    }
    public void append(Node n){
        insertAtTail(n);
    }
    public void insertAtIndex(Node n,int ind){
         if (size<ind)
             append(n);
         Node tmpN=head;//point to the first element
         int ti=0;
         while (ti<ind){ // continue until reaching node ind
             ti++;
             tmpN=tmpN.next;
         }
         n.next=tmpN.next;
         tmpN.next=n;
    }
    public E removeFirst(){
        if (head==null)
            return null;
        else{
            Node tmpN=head;
            head=head.next;
            size--;
            return (E)(tmpN.element);
        }
    }
    public E remove(int ind){
        if(size<ind)
            return null;
        //another way to check whether to remove the first elemant
        Node tmpN=head;
        if (ind==0){ // remove the first element
            head=head.next;
            return (E) (tmpN.element);
        }

        Node preN=null;
        int ti=0;
        while(ti<ind){
            preN=tmpN;
            tmpN=tmpN.next;
            ti++;
        }
//        if (preN==null) //remove the first node (i.e.,ind=0)
  //          head=tmpN.next;
    //    else  //not the first element, make the previous node to point to the next node of the removed node.
            preN=tmpN.next;

        return (E)(tmpN.element);
    }
    public E removedTail(){
        if(size>0)
            return remove(size-1);
        else
            return null;
    }
    public String toString(){
        String ts="";
        Node tmpN=head;
        for (int i=0;i<size;i++){
           // System.out.println("i="+i+" size="+size+ " element="+tmpN.element);
            ts+=(String)(tmpN.element)+" ; ";
            tmpN=tmpN.next;
        }
        return ts;
    }
    public static void main(String[] args) {
        DemoLinkedList<String> ll=new DemoLinkedList();
        System.out.println(ll);
        System.out.println("size="+ll.size());
        Node<String> n=new Node("Xukai Zou");
        ll.insertAtHead(n);
          System.out.println(ll);
        //System.out.println(ll.first());
        n=new Node("Bill Bill");
        ll.insertAtHead(n);
          System.out.println(ll);
        n=new Node("George Washingston");
        ll.append(n);
          System.out.println(ll);
        System.out.println(ll.size());
        n=new Node("Lincoln Scott");
        ll.insertAtHead(n);
          System.out.println(ll);
        ll.removeFirst();
          System.out.println(ll);


    }



}
*/
