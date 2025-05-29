package lab9;

import java.util.*;
import java.util.stream.*;

public class CuvinteLambda {
    public static void main(String[] args) {
        String text = "Acesta este un program scris cu java 8 si expresii lambda";

        List<String> cuvinte = Arrays.asList(text.split(" "));

        List<String> cuvinteLungi = cuvinte.stream()
                .filter(c -> c.length() >= 5)
                .collect(Collectors.toList());

        System.out.println("a) Cuvinte cu lungime >= 5: " + cuvinteLungi);
        System.out.println("Număr cuvinte: " + cuvinteLungi.size());

        List<String> cuvinteSortate = cuvinteLungi.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("b) Cuvinte ordonate: " + cuvinteSortate);

        Optional<String> cuvantCuP = cuvinte.stream()
                .filter(c -> c.startsWith("p"))
                .findFirst();

        System.out.print("c) Primul cuvânt care începe cu 'p': ");
        System.out.println(cuvantCuP.orElse("Nu există"));
    }
}
