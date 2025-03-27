package lab3.util.PasswordMakerModificat;

import java.security.SecureRandom;
import java.util.Random;

class StringRandomizer
{
    private static final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final Random random = new SecureRandom();

    public static String generateRandomString(int length)
    {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++)
        {
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }

        return sb.toString();
    }
}

public class MainModificat
{
    private static final int magicNumber = new SecureRandom().nextInt(6) + 5;
    private final String magicString;
    private final String name;
    private static final Random random = new SecureRandom();
    private static MainModificat instance;
    private static int instanceAccessCount = 0;

    static
    {
        instance = new MainModificat("Flavius");
    }

    private MainModificat(String name)
    {
        this.name = name;
        this.magicString = StringRandomizer.generateRandomString(20);
    }

    public static MainModificat getInstance()
    {
        instanceAccessCount++;
        return instance;
    }

    public String getPassword()
    {
        String randomPart = StringRandomizer.generateRandomString(magicNumber);
        String randomMagicPart = getRandomMagicString(10);
        String nameLength = String.valueOf(name.length());
        int randomInt = random.nextInt(51);

        return randomPart + randomMagicPart + nameLength + randomInt;
    }

    private String getRandomMagicString(int length)
    {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++)
        {
            sb.append(magicString.charAt(random.nextInt(magicString.length())));
        }
        return sb.toString();
    }

    public static int getInstanceAccessCount()
    {
        return instanceAccessCount;
    }

    public static void main(String args[])
    {
        MainModificat pm = MainModificat.getInstance();
        System.out.println("Generated Password: " + pm.getPassword());
        System.out.println("Instance accessed: " + MainModificat.getInstanceAccessCount() + " times");
    }
}
