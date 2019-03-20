public class ArrayStack<T> implements Stack {

    private T[] arr;
    private int top;

    public ArrayStack() {
        arr = (T[]) new Object[10];
        top = -1;
    }

    @Override
    public Object pop() {
        if (empty()) {
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arr[top--];


    }

    @Override
    public Object peek() {
        if (empty()) {
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arr[top];
    }

    @Override
    public void push(Object t) {
        if (top+1== arr.length) {

            growArray();
        }
        arr[++top] = (T) t;
    }

    @Override
    public boolean empty() {
        return top == -1;
    }

    public void growArray() {
        T[] temp = (T[]) new Object[arr.length * 2];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }
        arr = temp;
    }

}