package foundation;

/**
 * Author: amyas
 * Date: 2018/3/28/028
 * contact: geniusafteramyas@163.com
 */
public interface Stack<E> {

    void push(E e);

    E pop();

    int size();

    boolean isEmpty();
}
