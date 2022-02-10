package iterator.collection;

import lombok.AllArgsConstructor;

public class LinkedList<T> {
    int size;
    Node<T> head;
    Node<T>  tail;
    public void add(T t){
        if(size == 0 || head == null) {
            head = tail = new Node<T>(t,null);
            return ;
        }
        tail.next = new Node<T>(t,null);
        tail = tail.next;
    }

    public int size(){
        return this.size;
    }
}
@AllArgsConstructor
class Node<T> {
    T t ;
    Node<T> next ;

}
