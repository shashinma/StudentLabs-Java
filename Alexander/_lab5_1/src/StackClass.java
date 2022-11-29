import rzp.exceptions.stack.Stack;
import rzp.exceptions.stack.StackException;

public class StackClass implements Stack {
    private int maxSize = -1;
    private StackClass previous;
    private int item;

    StackClass(){}
    private StackClass(StackClass previous, int item){
        this.previous = previous;
        this.item = item;
    }

    /**
     * Инициализирует стек
     *
     * @param maxSize максимальное количество элементов в стеке
     * @throws StackException при повторной инициализации (и не выполняет её)
     */
    @Override
    public void init(int maxSize) throws StackException {
        if (this.maxSize != -1)
            throw new StackException("init");
        if (maxSize <= 0)
            throw new StackException("small");
        this.maxSize = maxSize;
    }

    /**
     * @return пуст ли стек
     */
    @Override
    public boolean isEmpty() {
        return this.previous == null;
    }

    /**
     * @return заполнен ли стек
     */
    @Override
    public boolean isFull() {
        return this.size() == maxSize;
    }

    /**
     * @return размер стека
     */
    @Override
    public int size() {
        return this.isEmpty() ? 0 : 1 + this.previous.size();
    }

    /**
     * @param item элемент
     * @return содержится ли элемент в стеке
     */
    @Override
    public boolean contains(int item) {
        for(StackClass stack = this; !stack.isEmpty();  stack = stack.previous){
            if (stack.item == item)
                return true;
        }
        return false;
    }

    /**
     * Возвращает элемент с вершины стека
     *
     * @return элемент с вершины стека
     * @throws StackException если стек пуст
     */
    @Override
    public int peek() throws StackException {
        if (isEmpty())
            throw new StackException("Stack is empty");
        return this.item;
    }

    /**
     * Удаляет элемент с вершины стека и возвращает его
     *
     * @return элемент с вершины стека
     * @throws StackException если стек пуст
     */
    @Override
    public int pop() throws StackException {
        if (this.isEmpty())
            throw new StackException("Stack is empty");

        int top = item;

        this.item = this.previous.item;
        this.previous = this.previous.previous;

        return top;
    }

    /**
     * Добавляет элемент в вершину стека
     *
     * @param item элемент
     * @throws StackException если стек уже переполнен
     */
    @Override
    public void push(int item) throws StackException {
        if (this.isFull())
            throw new StackException("Stack is full");

        this.previous = new StackClass(this.previous, this.item);
        this.item = item;
    }
}