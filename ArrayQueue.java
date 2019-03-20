public class ArrayQueue<T> implements Queue {
    private T[] arr;
    private int head;
    private int tail;

    public ArrayQueue() {
    head = 0;
    tail=0;
        arr = (T[]) new Object[10];
    }

    @Override
    public Object dequeue() {
        if (empty()) {
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        T temp = arr[head];
        head = (head + 1) % arr.length;
        if(head > arr.length){
            head=0;
        }
        return temp;

    }

    @Override
    public void enqueue(Object item) {
        if ((head + 1) % arr.length == tail) {
            growArray();
        }
        arr[tail] = (T) item;
        tail = (tail + 1) % arr.length;
    }

    @Override
    public boolean empty() {
        return head == tail;
    }
    protected void growArray() {
        T[] temp = (T[]) new Object[arr.length * 2];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }
        arr = temp;
    }
}
