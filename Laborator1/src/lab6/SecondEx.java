package lab6;


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