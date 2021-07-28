package DateStructures.array.v1;

/**
 * @Description description
 * @Author lzh
 */
public class Array <T>{

    private T[] arr;

    public Array(T...args){
        for (T arg : args) {
            add(arg);
        }
    }

    public boolean add(T arg){
        arr = (T[]) new Object[10];


        return true;
    }

    public int length(){

        return 0;
    }
}
