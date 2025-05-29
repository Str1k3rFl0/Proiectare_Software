import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class RandTextGenerator
{
    public static void main(String[] args)
    {
        String fileName = "outrand.txt";
        int lines = 5;
        int wordsPerLine = 10;
        int wordLength = 4;

        Random random = new Random();

        try (FileWriter writer = new FileWriter(fileName))
        {
            for (int i = 0; i < lines; i++)
            {
                List<String> words = new ArrayList<>();
                for (int j = 0; j < wordsPerLine; j++)
                {
                    words.add(generateRandomWord(wordLength, random));
                }
                Collections.sort(words);
                writer.write(String.join(" ", words) + "\n");
            }
            System.out.println("Fișierul 'outrand.txt' a fost generat cu succes.");
        }
        catch (IOException e)
        {
            System.err.println("Eroare la scrierea în fișier: " + e.getMessage());
        }
    }

    private static String generateRandomWord(int length, Random random)
    {
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < length; i++)
        {
            char c = (char) ('a' + random.nextInt(26));
            word.append(c);
        }
        return word.toString();
    }
}
