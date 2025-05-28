package lab6;

abstract class ACalculator<T>
{
    protected T state;

    public T result() { return state; }
    public void clear() { state = null; }
    public abstract void init(T initialstate);
}