package Algorithms;

import java.util.*;

/**
 * @Description description
 * @Author lzh
 */

interface List<E>{
    void add(E e);
    Iterator<E> iterator();
}

class A implements List<String>{

    @Override
    public void add(String s) {

    }

    @Override
    public Iterator<String> iterator() {
        return null;
    }
}

public class Test {
    static <T,E> void some(T[] a,HashMap<T,E> hashMap){

    }

    public static void main(String[] args) {

    }
}
