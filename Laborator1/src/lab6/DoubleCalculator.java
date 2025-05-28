package lab6;

public class DoubleCalculator extends ACalculator<Double>
{
    public DoubleCalculator(Double initialstate) { init(initialstate); }

    @Override
    public void init(Double initialstate) { this.state = initialstate; }

    public DoubleCalculator add(Double value) { this.state += value; return this; }
    public DoubleCalculator sub(Double value) { this.state -= value; return this; }
    public DoubleCalculator mul(Double value) { this.state *= value; return this; }
}