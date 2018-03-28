package foundation;

import java.util.Date;

/**
 * Author: amyas
 * Date: 2018/3/28/028
 * contact: geniusafteramyas@163.com
 */
public class LinkedQueue<T> implements Queue<T> {
    private int n;
    private Node first;

    public LinkedQueue() {
    }

    @Override
    public void enqueue(T t) {
        Node old = first;
        first = new Node();
        first.next = old;
        first.value = t;
        n++;
    }

    @Override
    public T dequeue() {
        if (first == null) throw new IndexOutOfBoundsException();
        T value = first.value;
        first = first.next;
        n--;
        return value;
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    class Node {
        private Node next;
        private T value;

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        LinkedQueue<Date> linkedQueue = new LinkedQueue<>();
        linkedQueue.enqueue(new Date());
        System.out.println(linkedQueue.dequeue());
    }
}
