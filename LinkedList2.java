import java.util.Iterator;


public class LinkedList2{
    static Node head;

    static class Node{
        Node next;
        int data;

        public Node(int d){
            next = null;
            data = d;
        }
    }

    void append(int newData){
        if(head == null){
            head = new Node(newData);
            head.next = null;
        }
        else{
            Node newNode = new Node(newData);
            newNode.next = null;
            
            Node last = head;
            while(last.next != null){
                last = last.next;
            }
            last.next = newNode;
        }
    } // append

    void push(int newData){
        
        Node newNode = new Node(newData);
        newNode.next = head;
        head = newNode; 
        
    } // push

    int size(LinkedList2 list){
        int num = 0;

        Node last = head;
        while(last != null){
            num++;
            last = last.next;
        }

        return num;
    } // size

    int nthElem(LinkedList2 list, int n){
        
        int len = size(list);
        int nthLast = len - n + 1;
        Node temp = head;

        for(int i = 1; i < nthLast; i++){
            temp = temp.next;
        }

        return temp.data;

    } // fifthElem
    
	// reverse linked list
	public Node reverseLL(Node n) {
		Node prev = null;
		Node current = head;
		Node next = null;
		
		while(current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next; 
		}
		
		n = prev;
		
		return n;
	} // reverseLL

    // Floyd's algorithm: keep 2 pointers
    // 1 pointer will move by 1 item and 2nd pointer will move by 2 items
    // if loop exists then at one point both the pointers will point to same item
    void detectLoop(Node node){
        Node slow = node;
        Node fast = node;

        while(slow != null && fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                System.out.println("Loop found at " + slow.data);
            }
        }
        System.out.println("Loop not found");

    } // detectloop

    void printList(){
        Node last = head;        
        while(last != null){
            System.out.print(last.data + " ");
            last = last.next;
        }
    } // printList

    public static void main(String[] args){
        LinkedList2 list = new LinkedList2();
        list.push(5);
        list.push(10);
        list.push(15);
        list.append(1);
        list.append(0);
        list.push(20);
        list.append(10);
        list.printList();
    
        System.out.printf("\n %dst/nd/th last element in the linked list is %d\n", 1, list.nthElem(list, 1)); 
        System.out.printf("\n %dst/nd/th last element in the linked list is %d\n", 2, list.nthElem(list, 2));
        System.out.printf("\n %dst/nd/th last element in the linked list is %d\n", 3, list.nthElem(list, 3));
        System.out.printf("\n %dst/nd/th last element in the linked list is %d\n", 4, list.nthElem(list, 4)); 
        System.out.printf("\n %dst/nd/th last element in the linked list is %d\n", 5, list.nthElem(list, 5));
        System.out.printf("\n %dst/nd/th last element in the linked list is %d\n", 6, list.nthElem(list, 6));    
        System.out.printf("\n %dst/nd/th last element in the linked list is %d\n", 7, list.nthElem(list, 7)); 
        
        n = list.reverseLL(n);
        
    } // main
}