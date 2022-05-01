package intermediate.coursework.linkedlists;
public class DemoLinkedList<E> {

    Node head;

    public DemoLinkedList(E e) {
        head = new Node(e);
    }

    public DemoLinkedList() {
        head = null;
    }

    public static void main(String[] args) {
        DemoLinkedList<String> dll = new DemoLinkedList();
        dll.addAtHead("Xindi Liu");
        dll.addTail("Edward Chen");
        dll.display();
        dll.addTail("Matthew Du");
        dll.display();
        dll.removeHead();
        dll.display();
        dll.addAtHead("Viswa Jay");
        dll.display();
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        int s = 0;
        Node tn = head;
        while (tn != null) {  //go through the linkedList to count
            s++;
            tn = tn.next;
        }
        return s;
    }

    public void addAtHead(E e) {
        if (head == null)  //empty linked list,
            head = new Node(e);
        else {//not an empty
            Node tn = new Node(e);  //create a new node with value e
            tn.next = head;  //linked to head
            head = tn; //head is modified to point to new node, i.e, new head.
        }

    }

    private Node getTailNode() {
        //finds the tail.
        Node tail = head;
        //Node tn = null;
        while (tail.next != null) {
            //tn = tail;
            tail = tail.next;
        }
        return tail;
    }

    public void addTail(E e) {
        if (head == null)
            head = new Node(e);
        else {
            //finds the tail.
            Node tail = getTailNode();
            //after while, tail points to the last node of the list
            tail.next = new Node(e);//create new node and link it to tail.
            //tn.next = tail;  //link the new node to the last node.

        }
    }

    public E getHead() {
        if (head == null) {
            return null;
        } else {
            return (E) (head.value);
        }
    }

    public E getTail() {
        if(head == null) {
            return null;
        } else {
            Node tail = getTailNode();
            return (E) (tail.value);
        }
    }

    public E removeHead() {
        if(head == null) {
            return null;
        }
        //Note that tn is a temporary variable; it stores the head of the head node that will be removed. Once the
        //head is removed, the node of the head remains, and while it poitns to the NEW head of the head node, nothing
        //points to it, so it will be automatically garbage collected.
        Node tn = head;
        head = head.next;
        return (E) (tn.value);
    }

    //Removes items in the linked list at the tail and returns the removed value from the linked list.
    public E removeTail() {
        //Implemented for homework (4/9/2022), implement a linked list tail removal application.
        if (head == null)
            return null;

        if (head.next == null) { //Only one element
            E e = (E) head.value;
            head = null;
            return e;
        }

        //More than one element
        Node secondToLast = head;
        while (secondToLast.next.next != null) {
            secondToLast = secondToLast.next;
        }

        //The former tail (about to be deleted, just cached permanently).
        E e = (E) secondToLast.next.value;

        //Deletes the last node and returns its value (previously cached)
        secondToLast.next = null;
        return e;
    }

    //Adds a node with value e before position i (with i >= 0)
    public boolean AddAtPosition(E e, int i) {
        //Implemented for homework (4/9/2022), implement a method to add a node with value e BEFORE element i at position i.
        int sz = size();
        //Adds at the head of the linked list if the provided index for the node with value e is at 0.
        if(i == 0) {
            addAtHead(e);
            return true;
        }
        if(sz < i) {
            System.out.println("The line has only " + sz + " elements, but you want to add at a large position " + i);
            return false;
        }

        //In the special case that sz and i are both equal to 0 (that is, the linked list is empty and we're adding
        //an initial value at position 0, then the addTail() method is basically initializing the linked list with
        //a singular starting value at its beginning node.
        if(sz == i) {
            addTail(e);
            return true;
        }

        //Otherwise, insert directly at position i
        //We initialize counter = 1 because we start there when we're adding elements to the linked list (the case
        //for i = 0 has already been covered above with adding to the head of the linked list).
        int counter = 1; //The reason for initializing counter to 1 instead of 0 is because
        //we need to arrive at the element before the specified element to perform operations on the specified element
        //from the standing position of the previous element.
        Node tn = head;
        while(counter < i) { //Go to the element with index i
            tn = tn.next;
            counter++;
        }

        //Initializes and inserts the new node from the given value and positional parameters
        Node toBeAdded = new Node(e);

        //Sets the next node of toBeAdded to the node originally after tn
        toBeAdded.next = tn.next;
        tn.next = toBeAdded;
        return true;
    }
    //Removes the element at position i (with i >= 0)
    public E removeElementAtPosition(int i) {
        //Implemented for homework (4/9/2022), implement a method that removes the element AT position i.
        if(head == null) {
            return null;
        }
        int sz = size();
        if(sz < i + 1) {//There aren't as many elements present in the linked list as the value i
            return null;
        }
        if(sz == i + 1) {
            return removeTail();
        }
        int count = 1; //If set to 0, it will not be correct. We need to arrive at the element before the
        //specified element to perform operations on the specified element from the standing position of the previous
        //element
        Node oneBeforeI = head;
        while(count < i) {
            oneBeforeI = oneBeforeI.next;
            count++;
        }
        E e = (E) oneBeforeI.next.value;
        oneBeforeI.next = oneBeforeI.next.next;
        return e;
    }

    public E getElement(int i) {
        //TODO: For homework (4/16/2022), implement a method that gets the value of the linked list element at index i.
        int count = 0;
        Node tn = head;
        while ((tn != null) && (count < i)) {
            tn = tn.next;
            count++;
        }
        if(count < i) { //Element with index i does not exist
            return null;
        } else { //We can just return the converted value of the element tn.
            return (E) tn.value;
        }
    }

    public void setValue(E e, int i) {
        //TODO: For homework (4/16/2022), implement a method that changes the value of element i to e (modifying the node when the linked list is being joined.
    }

    public void display() {
        Node tn = head;
        System.out.println("Beginning of linked list: ");
        System.out.println();
        while(tn != null) {
            System.out.print(tn.value + " ");
            tn = tn.next;
        }
        System.out.println();
        System.out.println();
        System.out.println("End of linked list.");
    }

    private class Node<E> {
        E value;
        Node next;

        //NOTE: When next = null, the initialized node is a dangling node, with no direction or positional relation
        //at all whatsoever.
        public Node(E e) {
            value = e;
            next = null;
        }
    }

}