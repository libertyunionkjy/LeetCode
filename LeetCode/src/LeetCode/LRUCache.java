package LeetCode;

public class LRUCache {
    public LRUCache(int capacity) {

    }

    public int get(int key) {

    }

    public void put(int key, int value) {

    }
}



class DoubleLinked{
    public Node head,tail;
    DoubleLinked(){
        this.head = new Node(0,0);
        this.tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
    }

    public Node addFirst(Node node){

    }
}

class Node {
    public int key, val;
    public Node prev, next;

    Node(int key,int val){
        this.key = key;
        this.val = val;
    }

}
