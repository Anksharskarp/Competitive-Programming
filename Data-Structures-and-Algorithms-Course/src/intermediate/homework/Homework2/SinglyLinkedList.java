package intermediate.homework.Homework2;

//Creates a singly linked list (that can only be traversed in one direction) that has nodes and elements of any type
//(hence the usage of generics).
public class SinglyLinkedList<E> {
    //Instance variables of the SinglyLinkedList class.
    Node<E> head; //Head node of the list.
    Node<E> tail; //Last node of the list.
    int size = 0; //Number of nodes in the list.

    //Constructs an initially empty list.
    public SinglyLinkedList() {
        head = null;
        tail = null;
    }

    //Returns the first method.
    public E getFirst() {
        if(isEmpty()) {
            return null;
        }

        return head.getElement();
    }

    //Returns the last method.
    public E getLast() {
        if(isEmpty()) {
            return null;
        }

        return tail.getElement();
    }

    //Returns the size of the linked list (number of nodes in the list).
    public int size() {
        return size;
    }

    //Checks if the linked list is empty.
    public boolean isEmpty() {
        return size == 0;
    }

    //Adds an element e of type E to the front of the list.
    public void addFirst(E e) {
        head = new Node<>(e, head); //Create and link a new node.
        if(size == 0) {
            //The new node could also become the new tail.
            tail = head;
        }
        size++;
    }

    //Adds an element e of type E to the end of the list.
    public void addLast(E e) {
        Node<E> newest = new Node<>(e, null); //Node will eventually be the tail.
        if(isEmpty()) {
            head = newest; //It is possible that the list could have previously been empty.
        } else {
            tail.setNext(newest); //New node created after existing tail.
        }
        tail = newest; //New node after existing tail.
        size++; //New node becomes the tail.
    }

    //Removes and returns the first element of the linked list.
    public E removeFirst() {
        if(isEmpty()) {
            return null; //There is nothing to remove.
        }
        E answer = head.getElement();
        head = head.getNext(); //Will become null if the list only has one node.
        size--;
        if(size == 0) {
            tail = null; //Special case where the list becomes empty.
        }
        return answer;
    }
}

//We add an Abstract Data Type (ADT) so that it can take any type of parameter (for both the constructor, class
//variables, or instance variables.
class Node<E> {
    E element; //Reference to the element stored at this node.
    Node<E> next; //Reference to the subsequent node in the list.

    //Node Constructor
    public Node(E e, Node<E> n) {
        element = e;
        next = n;
    }

    //Gets the specified element of the node.
    public E getElement() {
        return element;
    }

    //Gets the next node (and the node/element that it points to
    public Node<E> getNext() {
        return next;
    }

    //Sets the next node to a value.
    public void setNext(Node<E> n) {
        next = n;
    }
}