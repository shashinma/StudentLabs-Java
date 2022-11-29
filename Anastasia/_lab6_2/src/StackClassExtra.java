import rzp.generics.stack.StackException;
import rzp.generics.stack.StackExtra;
public class StackClassExtra<T> implements StackExtra<T> {
    private int maxSize = -1;
    private StackClassExtra<T> previous;
    private T item;

    public StackClassExtra() {
    }

    public StackClassExtra(StackClassExtra<T> previous, T item) {
        this.previous = previous;
        this.item = item;
    }

    public void init(int maxSize) throws StackException {
        if (this.maxSize != -1)
            throw new StackException("Already initialized");
        if (maxSize <= 0)
            throw new StackException("Size is too small");
        this.maxSize = maxSize;
    }

    public boolean isEmpty() {
        return this.previous == null;
    }

    public boolean isFull() {
        return this.size() == maxSize;
    }

    public int size() {
        return this.isEmpty() ? 0 : 1 + this.previous.size();
    }

    public boolean contains(T item) {
        for (StackClassExtra<T> stack = this; !stack.isEmpty(); stack = stack.previous)
            if (stack.item.equals(item))
                return true;
        return false;
    }

    public T peek() throws StackException {
        if (this.isEmpty ())
            throw new StackException("Stack is empty");
        return this.item;
    }

    public T pop() throws StackException {
        if (this.isEmpty())
            throw new StackException("Stack is empty");

        T top = item;
        this.item = this.previous. item;
        this.previous = this.previous.previous;
        return top;
    }

    public void push(T item) throws StackException {
        if (this.isFull())
            throw new StackException("Stack overflow");

        this.previous = new StackClassExtra<>(this.previous, this.item);
        this.item = item;
    }

    public void push(T[] items) throws StackException, IllegalStateException {
        int canPush = this.maxSize - this.size();
        if (maxSize == -1)
            throw new IllegalStateException("Not initialized");
        if (items.length > canPush)
            throw new StackException("Too much elements");

        for (T item : items)
            this.push(item);
    }

}