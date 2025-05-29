package lab9;

import java.util.*;
import java.util.stream.*;

public class StreamOperations {
    public static void main(String[] args)
    {
        Random random = new Random();
        List<Integer> numbers = random.ints(10, 5, 26)
                .boxed()
                .collect(Collectors.toList());

        System.out.println("Lista originală: " + numbers);

        int suma = numbers.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Suma elementelor: " + suma);

        int max = numbers.stream().mapToInt(Integer::intValue).max().orElseThrow();
        int min = numbers.stream().mapToInt(Integer::intValue).min().orElseThrow();
        System.out.println("Valoarea maximă: " + max);
        System.out.println("Valoarea minimă: " + min);

        List<Integer> filtrate = numbers.stream()
                .filter(n -> n >= 10 && n <= 20)
                .collect(Collectors.toList());
        System.out.println("Elemente între 10 și 20: " + filtrate);

        List<Double> numereDouble = numbers.stream()
                .map(Double::valueOf)
                .collect(Collectors.toList());
        System.out.println("Lista de Double: " + numereDouble);

        boolean contine12 = numbers.contains(12);
        System.out.println("Lista conține valoarea 12? " + (contine12 ? "Da" : "Nu"));
    }
}
