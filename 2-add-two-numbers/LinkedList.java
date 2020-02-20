public class LinkedList{
        Node head;
        static class Node{
            int data;
            Node next;
            Node(int d){
                data = d;
                next = null;
            }
        }
    public static void main(String[] args) {
        LinkedList llist1 = new LinkedList();
        llist1.head = new Node(11);
        Node second = new Node(22);
        Node third = new Node(33);
        llist1.head.next = second;
        second.next= third;
        printLList(llist1);
    }

    static void printLList(LinkedList llist){
        Node n = llist.head;
        while (n != null){
            System.out.print(n.data+" ");
            n = n.next;
        }
    }

}
