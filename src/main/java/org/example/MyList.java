package org.example;
/**Class used to make a list using linked Lists*/
public class MyList {
    public int length;
    //these two nodes will be updated to tell where the front and the back of the line are.
    private Node front;
    private Node back;
    //First we add a class that has creates Nodes for the LinkedList. The data is the house. Next is null unless assigned.
    /** This is the Node class. It is used to create the linked list nodes.*/
    class Node{
        private House data;
        private Node next;
        Node(House data){
            this.data =data;
            this.next = null;

        }
    }
    /**Default constructor*/
    MyList(){
        this.front = null;
        this.back = null;
        this.length = 0;
    }
    /**to make a deepcopy of a LinkedList we cant just copy the linked list. We need to copy all data of each node individually.*/
    MyList(MyList other){
        if(other.isEmpty()){
            this.front = null;
            this.back = null;
            this.length = 0;
        }
        else{
        //have to use the addtoback method so the list is not in reverse since the normal add method adds the node to the front. therefore reversing the list
            addToBack(other.front.data.deepCopy());
            Node temp = other.front.next;

            while(temp!=null){
                addToBack(temp.data.deepCopy());
                temp = temp.next;

            }
        }

    }
    /** Method used to add a node to the back of a list*/
    public void addToBack(House house){
        Node newNode = new Node(house);
        if(isEmpty()){
            front = newNode;
            back = newNode;
            length++;
        }
        else{
            back.next = newNode;
            back = back.next;
        }

    }
    /**Adds a House object to the List*/
    public void add(House a) {
        //adding one so we add to the length
        Node newNode = new Node(a);
        if(isEmpty()){
            front = newNode;
            back = newNode;
            length++;
        }
        else{
            newNode.next = front;
            front = newNode;
            length++;
        }
    }
    /**Returns true if the List is empty*/

    public boolean isEmpty() {
        return front == null;
    }
    /** A deepcopy method that uses the deepcopy constructor */
    public MyList deepCopy(){
        MyList myList = new MyList(this);
        return myList;
    }
    /** method used to find the owner of a house and return the house, null otherwise*/
    public House find(String owner){
        Node temp = front;
        while(temp!=null){
            if(temp.data.getOwner().equals(owner)) return temp.data;
            temp = temp.next;
        }
        return null;
    }
    /** A function to get the house in the linked list based of a index given. Used ofr rehasing**/
    public House get(int i) {


        Node temp = front;
        int index = 0;

        while (temp != null && index != i) {
            temp = temp.next;
            index++;
        }



        return temp.data;
    }

}
