package lab5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExercitiuFisier
{
    public static void main(String[] args)
    {
        String inputFile = "in.txt";
        String outputFile = "out.txt";
        StringBuilder resultA = new StringBuilder();
        StringBuilder resultB = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile)))
        {
            String line;
            while ((line = reader.readLine()) != null)
            {
                resultA.append(line).append("\n\n");

                for (char c : line.toCharArray())
                {
                    resultB.append(c);
                    if (c == '.')
                    {
                        resultB.append("\n");
                    }
                }
                resultB.append("\n");
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        System.out.println("Modificare finala A:\n" + resultA);
        System.out.println("Modificare finala B:\n" + resultB);
    }
}
