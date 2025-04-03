package lab6;

abstract class ACalculator<T>
{
    protected T state;

    public T result() { return state; }
    public void clear() { state = null; }
    public abstract void init(T initialstate);
}

class NewIntCalculator extends ACalculator<Integer>
{
    public NewIntCalculator(Integer initialstate) { init(initialstate); }

    @Override
    public void init(Integer initialstate) { this.state = initialstate; }

    public NewIntCalculator add(Integer value) { this.state += value; return this; }
    public NewIntCalculator sub(Integer value) { this.state -= value; return this; }
    public NewIntCalculator mul(Integer value) { this.state *= value; return this; }
}

class DoubleCalculator extends ACalculator<Double>
{
    public DoubleCalculator(Double initialstate) { init(initialstate); }

    @Override
    public void init(Double initialstate) { this.state = initialstate; }

    public DoubleCalculator add(Double value) { this.state += value; return this; }
    public DoubleCalculator sub(Double value) { this.state -= value; return this; }
    public DoubleCalculator mul(Double value) { this.state *= value; return this; }
}

public class SecondEx
{
    public static void main(String[] args)
    {
        NewIntCalculator intCalc = new NewIntCalculator(10);
        int intResult = intCalc.add(5).sub(3).mul(2).result();
        System.out.println("Int result: " + intResult);

        DoubleCalculator doubleCalc = new DoubleCalculator(10.0);
        double doubleResult = doubleCalc.add(5.0).sub(3.3).mul(2.2).result();
        System.out.println("Double result: " + doubleResult);
    }
}
