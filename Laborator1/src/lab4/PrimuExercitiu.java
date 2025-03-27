package lab4;

import java.util.*;

public class PrimuExercitiu
{
    public static void main(String args[])
    {
        Random rand = new Random();
        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();

        for (int i = 0; i < 5; i++)
        {
            x.add(rand.nextInt(11));
        }

        for (int i = 0; i < 7; i++)
        {
            y.add(rand.nextInt(11));
        }

        Collections.sort(x);
        Collections.sort(y);

        System.out.println("Lista lui x: " + x);
        System.out.println("Lista lui y: " + y);

        // a)
        List<Integer> xPlusY = new ArrayList(x);
        xPlusY.addAll(y);
        Collections.sort(xPlusY);
        System.out.println("Lista lui xPLusY: " + xPlusY);

        // b)
        Set<Integer> zSet = new TreeSet<>(x);
        zSet.retainAll(y);
        System.out.println("zSet (valori comune): " + zSet);

        // c)
        List<Integer> xMinusY = new ArrayList<>(x);
        xMinusY.removeAll(y);
        System.out.println("Lista lui xMinusY: " + xMinusY);

        // d)
        int p = 4;
        List<Integer> xPlusYLimitedByP = new ArrayList<>();
        for (int num : xPlusY)
        {
            if (num <= p)
            {
                xPlusYLimitedByP.add(num);
            }
        }

        System.out.println("xPLusYLimitedByP (<= " + p + "): " + xPlusYLimitedByP);
    }
}
