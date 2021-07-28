package DateStructures.linkedlist.SimpleLink;

import DateStructures.linkedlist.ILinkedList;

/**
 * @Description 单链表
 * @Author lzh
 */
public class SimpleLinkedList<T> implements ILinkedList<T> {

    private SimpleLinkNode<T> head;

    public SimpleLinkedList(SimpleLinkNode<T> head){
        this.head = head;
    }

    @Override
    public boolean isEmpty() {
        return this.head==null;
    }

    @Override
    public int length() {
        int length = 0;
        while (this.head != null){
            length++;
            this.head = head.next;
        }
        return length;
    }

    @Override
    public boolean add(T data) {
        return add(Integer.MAX_VALUE,data);
    }

    @Override
    public boolean add(int index, T data) {
        if(data == null){
            return false;
        }
        if(this.head==null || index < 1){
            this.head = new SimpleLinkNode<>(this.head,data);
        }else {
            int count = 0;
            while (this.head != null && count < index){
                this.head = head.next;
                count++;
            }
            this.head.next = new SimpleLinkNode<>(this.head.next,data);
        }
        return true;
    }

    @Override
    public boolean remove(int index) {

        T obj = null;
        if(index > length()){
            return false;
        }
        int count = 0;
        while (count < index-1){
            head = head.next;
            count++;
        }
        head.next = head.next.next;
        return true;
    }

    @Override
    public boolean clear() {
        return false;
    }

    @Override
    public boolean set(int index, T data) {
        return false;
    }

    @Override
    public T get(int index) {
        return null;
    }
}
