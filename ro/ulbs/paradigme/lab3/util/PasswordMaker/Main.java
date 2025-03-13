package ro.ulbs.paradigme.lab3.util.PasswordMaker;

import java.security.SecureRandom;
import java.util.Random;

class StringRandomizer
{
    private static final String chars = "ABCDEFGHUJKLMOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
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

public class Main
{
    private static final int magicNumber = new SecureRandom().nextInt(6) + 5;
    private final String magicString;
    private final String name;
    private static final Random random = new SecureRandom();

    public Main(String name)
    {
        this.name = name;
        this.magicString = StringRandomizer.generateRandomString(20);
    }

    public String getPassword()
    {
        String randomPart = StringRandomizer.generateRandomString(magicNumber);
        String randomMagicPart = getRandomMagicString(10);
        String nameLenght = String.valueOf(name.length());
        int randomInt = random.nextInt(51);

        return randomPart + randomMagicPart + nameLenght + randomInt;
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

    public static void main(String[] args)
    {
        Main pm = new Main("Flavius");
        System.out.println("Generated Password: " + pm.getPassword());

    }
}