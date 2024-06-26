public class Stack<T> {
    T[] stack;
    int size;
    static final int DEFAULT_CAPACITY = 10;
    public Stack(){
        this.stack = (T[]) new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }
    public Stack(int capacity){
        this.stack = (T[]) new Object[capacity];
        this.size = 0;
    }
    public void push(T element){
        if(stack.length<=size){
            resize();
        }
        stack[size] = element;
    }
    public T pop(){
        T value = stack[size-1];
        stack[size-1] = null;
        size--;
        return value;
    }
    public T peek(){
        return stack[size-1];
    }
    public boolean isEmpty(){
        return size==0;
    }
    public int size(){
        return size;
    }
    public void resize(){
        T[] newStack = (T[]) new Object[stack.length * 2];
        System.arraycopy(stack, 0, newStack, 0, stack.length);
        stack = newStack;
    }
}
