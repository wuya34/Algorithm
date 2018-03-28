package foundation;

import java.util.Date;
import java.util.NoSuchElementException;

/**
 * Author: amyas
 * Date: 2018/3/28/028
 * contact: geniusafteramyas@163.com
 * 数组实现队列
 */
public class ArrayQueue<T> implements Queue<T> {
    private Object[] list;
    private int index;

    public ArrayQueue() {
        list = new Object[5];
    }

    private void resize(int size) {
        Object[] tmp = new Object[size];
        for (int i = 0; i < list.length; i++) {
            tmp[i] = list[i];
        }
        list = tmp;

    }

    @Override
    public void enqueue(T t) {
        if (index == list.length){
            resize(2*index);
        }
        list[index++] = t;
    }

    @Override
    public T dequeue() {
        if (index<1) throw new ArrayIndexOutOfBoundsException("queue is empty!");
        return (T) list[--index];
    }

    @Override
    public int size() {
        return list.length;
    }

    @Override
    public boolean isEmpty() {
        return list.length!=0;
    }

    public static void main(String[] args) {
        ArrayQueue<Date> q = new ArrayQueue<>();
        for (int i = 0; i < 5; i++) {
            q.enqueue(new Date());
            System.out.println(q.dequeue());
        }
        q.dequeue();




    }
}
