package foundation;

/**
 * Author: amyas
 * Date: 2018/3/28/028
 * contact: geniusafteramyas@163.com
 */
public interface Queue<E> {
    void enqueue(E e);

    E dequeue();

    int size();

    boolean isEmpty();
}
