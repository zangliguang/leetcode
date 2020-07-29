package uncomplete;

public class OlInterview1 {
    public static void main(String[] args) {
        Node n1=new Node(1);
        Node n2=new Node(2);
        Node n3=new Node(3);
//        Node n4=new Node(4);
//        Node n5=new Node(5);
        n1.next=n2;
        n2.next=n3;
//        n3.next=n4;
//        n4.next=n5;
        Node result = revertByPair(n1);
        System.out.println(result);

    }
    static Node revertByPair(Node head){
        if(head==null||head.next==null){
            return head;
        }
        Node nextHead=revertByPair(head.next.next);
        Node result =head.next;
        result.next=head;
        head.next=nextHead;

        return result;
    }

    static class  Node{
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
}
