import rzp.exceptions.stack.StackException;
import rzp.exceptions.stack.StackExtra;

public class StackClassExtra implements StackExtra {
    private int maxSize = -1;
    private StackClassExtra previous;
    private int item;

    public StackClassExtra(){}
    private StackClassExtra(StackClassExtra previous, int item){
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
            throw new StackException("Init");
        if (maxSize <= 0)
            throw new StackException("Small");
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
        for(StackClassExtra stack = this; !stack.isEmpty(); stack = stack.previous){
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

        this.previous = new StackClassExtra(this.previous, this.item);
        this.item = item;
    }

    /**
     * Добавляет все указанные элементы в вершину стека по очереди
     *
     * @param items элементы
     * @throws StackException        если элементов больше, чем свободного места в стеке
     *                               (элементы при этом не добавлять в стек!)
     * @throws IllegalStateException если стек ещё не был инициализирован {@link StackExtra#init(int)}
     *                               (элементы при этом не добавлять в стек!)
     */
    @Override
    public void push(int... items) throws StackException, IllegalStateException {
        int checkPushCondition = this.maxSize - this.size();

        if (maxSize == -1)
            throw new IllegalStateException("Not init");
        if (items.length > checkPushCondition)
            throw new StackException("Too many items");

        for (int item : items)
            this.push(item);
    }
}