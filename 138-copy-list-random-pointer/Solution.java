import java.util.HashMap;

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

// a deep copy is required, instead of a shallow copy
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        if (head.next == null) {
            Node res = new Node(head.val);
            if (head.random != null) {
                res.random = res;
            }
            return res;
        }

        List<Node> order = new ArrayList<Node>();
        List<Integer> indexOfRandom = new ArrayList<Integer>();

        Node temp = head;
        while (temp != null) {
            Node node = new Node(temp.val);
            order.add(node); // creating a new copy for each node in the linked-list
            if (temp.random == null) {
                indexOfRandom.add(null);
            } else {
                indexOfRandom.add(getIndexOfNode(head, temp.random));
            }
            temp = temp.next;
        }


        Node res = order.get(0);
        for (int i = 0; i < order.size(); i++) {
            Node node = order.get(i); // refering to RAM address
            if (i + 1 < order.size()) {
                node.next = order.get(i + 1);
            } else {
                node.next = null;
            }
           
            if (indexOfRandom.get(i) == null) {
                node.random = null;
            } else {
                node.random = order.get(indexOfRandom.get(i));
            }
        }
        return res;
    }

    // getting the index of a node in a linked-list
    private int getIndexOfNode(Node head, Node node) {
        int i = 0;
        while (head != node) {
            i++;
            head = head.next;
        }
        return i;
    }
}