package uncomplete;

public class OlInterview2 {
    public static void main(String[] args) {

        Node n1=new Node(1);
        n1.next=new Node(2);
        n1.next.next=new Node(3);
        n1.next.next.next=new Node(4);

        Node n2=new Node(2);
        n2.next=new Node(3);
//        n2.next.next=new Node(3);
//        n2.next.next.next=new Node(1);
        Node result=getSumOfTwoLink2(n1,n2);
        System.out.println(result.val);
    }

    static Node getSumOfTwoLink2(Node A, Node B) {
        Node newA=revertNode(A);
        Node newB=revertNode(B);
        int currentValue=0;
        int nextAdd=0;
        Node result = null;
        while(null!=newA&&null!=newB){
            currentValue=(newA.val+newB.val+nextAdd)%10;
            Node current = new Node(currentValue);
            nextAdd=(newA.val+newB.val+nextAdd)/10;
            current.next=result;
            result=current;
            newA=newA.next;
            newB=newB.next;
        }
        Node secondPart=newA;
        if(newB!=null){
            secondPart=newB;
        }
        while (secondPart!=null){
            currentValue=(secondPart.val+nextAdd)%10;
            Node current = new Node(currentValue);
            nextAdd=(secondPart.val+nextAdd)/10;
            current.next=result;
            result=current;
            secondPart=secondPart.next;
        }

        if(nextAdd>0){
            Node current=new Node(nextAdd);
            current.next=result;
            return current;
        }

        return result;
    }

    static Node revertNode(Node node){
        if(node==null||node.next==null){
            return node;
        }
        Node result=revertNode(node.next);
        node.next.next=node;
        node.next=null;


        return result;

    }

    static Node getSumOfTwoLink(Node A, Node B) {
        Node Ahead = A;
        int valueA = 0;
        while (Ahead != null) {
            valueA*=10;
            valueA += Ahead.val;
            Ahead = Ahead.next;
        }
        Node Bhead = B;
        int valueB = 0;
        while (Bhead != null) {
            valueB*=10;
            valueB += Bhead.val;
            Bhead = Bhead.next;
        }
        int resultValue = valueA + valueB;

        Node result = null;
        while (resultValue > 0) {
            Node current = new Node(resultValue % 10);
            current.next = result;
            resultValue /= 10;
            result = current;

        }


        return result;
    }


    static class Node {
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
