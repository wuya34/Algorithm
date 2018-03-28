package foundation;

import java.util.Iterator;

/**
 * Author: amyas
 * Date: 2018/3/28/028
 * contact: geniusafteramyas@163.com
 * <p>
 * 背包实现。
 */
public class Bag<T> implements Iterator<T>, Iterable<T> {
    private Object[] list;
    private int index = 0;
    private int flag = 0;

    public Bag() {
        list = new Object[5];
    }

    public Bag(int size) {
        if (size < 1) throw new IllegalArgumentException("initial size can't be less than 1");
        list = new Object[size];
    }

    public static void main(String[] args) {
        Bag<Integer> bag = new Bag<>();
        for (int i = 0; i < 10; i++) {
            bag.add(i);
        }

        for (Integer integer : bag) {
            System.out.println(integer);
        }

    }

    public void add(T item) {
        if (index == list.length) {
            resize(index * 2);
        }
        list[index++] = item;
    }

    private void resize(int size) {
        Object[] tmp = new Object[size];
        for (int i = 0; i < list.length; i++) {
            tmp[i] = list[i];
        }
        list = tmp;

    }

    @Override
    public boolean hasNext() {
        return flag < list.length - 1;
    }

    @Override
    public T next() {
        return (T) list[flag++];
    }

    @Override
    public Iterator<T> iterator() {
        // 最好返回一个新的iterator
        return this;
    }
}
