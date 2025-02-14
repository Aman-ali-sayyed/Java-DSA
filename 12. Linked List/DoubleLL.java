public class DoubleLL {
    public class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    //Add First
    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if(head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    //print
    public void print() {
        if(head == null) {
            System.out.println("Doubly Linked List is empty!");
            return;
        }
        Node temp = head;
        System.out.print("null<->");
        while(temp != null) {
            System.out.print(temp.data + "<->");
            temp = temp.next;
        }
        System.out.print("null");
        System.out.println();
    }

    //Add Last
    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;

        if(tail == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    //Remove First
    public int removeFirst() {
        if(head == null) {
            System.out.println("Doubly Linked List is empty!");
            return Integer.MIN_VALUE;
        } else if(size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        head.prev = null;
        size--;
        return val;
    }

    //remove Last
    public int removeLast() {
        if(tail == null) {
            System.out.println("Doubly Linked List is empty!");
            return Integer.MIN_VALUE;
        } else if(size == 1) {
            int val = tail.data;
            head = tail = null;
            size--;
            return val;
        }
        int val = tail.data;
        Node temp = tail.prev;
        temp.next = null;
        tail = temp;
        size--;
        return val;
    }

    public void reverseDLL() {
        Node prev = null;
        Node curr = head;
        Node next;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            curr.prev = next;

            prev = curr;
            curr = next;
        }

        head = prev;
    }
    public static void main(String[] args) {
        DoubleLL dll = new DoubleLL();
        dll.addFirst(3);
        dll.addFirst(2);
        dll.addFirst(1);
        dll.addLast(4);
        dll.addLast(5);
        dll.print();
        
        dll.reverseDLL();
        dll.print();

       
    }
}
