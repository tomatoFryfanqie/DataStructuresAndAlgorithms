package DateStructures.linkedlist.SimpleLink;

/**
 * @Description 链表节点的定义
 * @author lzh
 */
public class SimpleLinkNode <T>{

    public T data;
    public SimpleLinkNode<T> next;

    public SimpleLinkNode(){}

    public SimpleLinkNode(T data){
        this.data = data;
    }

    public SimpleLinkNode(SimpleLinkNode<T> next, T data){
        this.next = next;
        this.data = data;
    }
}
