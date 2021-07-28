package DateStructures.linkedlist;

/**
 * @Description 链表的顶级接口
 * @author lzh
 */
public interface ILinkedList <T>{

    /**
     * 判断链表是否为空
     * @return
     */
    boolean isEmpty();

    /**
     *
     * @return
     */
    int length();

    /**
     * 添加节点
     * @param data
     * @return
     */
    boolean add(T data);

    /**
     *
     * @param index
     * @param data
     * @return
     */
    boolean add(int index, T data);

    /**
     *
     * @param index
     * @return
     */
    boolean remove(int index);

    /**
     *
     * @return
     */
    boolean clear();

    /**
     *
     * @param index
     * @param data
     * @return
     */
    boolean set(int index, T data);

    /**
     *
     * @param index
     * @return
     */
    T get(int index);
}
