package lab6;

public class NewIntCalculator extends ACalculator<Integer>
{
    public NewIntCalculator(Integer initialstate) { init(initialstate); }

    @Override
    public void init(Integer initialstate) { this.state = initialstate; }

    public NewIntCalculator add(Integer value) { this.state += value; return this; }
    public NewIntCalculator sub(Integer value) { this.state -= value; return this; }
    public NewIntCalculator mul(Integer value) { this.state *= value; return this; }
}