package deque;
import java.util.Scanner;

public class _10866_덱 {
    static Node head;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int round = sc.nextInt();
        for(int r=0; r<round; r++){
            String o = sc.next();
            switch(o) {
                case "push_front": push_front(sc.nextInt()); break;
                case "push_back": push_back(sc.nextInt()); break;
                case "pop_front": sb.append(pop_front()+"\n"); break;
                case "pop_back": sb.append(pop_back()+"\n"); break;
                case "size": sb.append(size()+"\n"); break;
                case "empty": sb.append(empty()+"\n"); break;
                case "front": sb.append(front()+"\n"); break;
                case "back": sb.append(back()+"\n"); break;
            }
        }
        System.out.println(sb.toString());
    }

    static void push_front(int num){
        Node node = new Node(num);
        node.next = head;
        head = node;
    }

    static void push_back(int num){
        Node node = new Node(num);
        if(head == null){
            head = node;
        } else{
            Node curr = head;
            while(curr.next != null){
                curr = curr.next;
            }
            curr.next = node;
        }
    }

    static int pop_front(){
        if(head == null){
            return -1;
        } else {
            Node front = head;
            head = head.next;
            return front.data;
        }
    }

    static int pop_back(){
        if(head == null){
            return -1;
        } else {
            Node curr = head;
            
            while(curr.next != null){
                curr = curr.next;
            }
            if(curr == head){
                head = null;
                return curr.data;
            }
            Node preCurr = head;
            while(preCurr.next != curr){
                preCurr = preCurr.next;
            }
            preCurr.next = null;
            return curr.data;
        }
    }

    static int size(){
        if(head == null){
            return 0;
        }
        int count = 1;
        Node curr = head;
        while(curr.next != null){
            count++;
            curr = curr.next;
        }
        return count;
    }

    static int empty(){
        if(head == null){
            return 1;
        } else {
            return 0;
        }
    }

    static int front(){
        if(empty() == 1){
            return -1;
        } else {
            return head.data;
        }
    }

    static int back(){
        if(empty() == 1){
            return -1;
        } else {
            Node curr = head;
            while(curr.next != null){
                curr = curr.next;
            }
            return curr.data;
        }
    }
}

class Node{
    int data;
    Node next;

    Node(int data){
        this.data = data;
        this.next = null;
    }
}