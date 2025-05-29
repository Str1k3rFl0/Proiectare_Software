package lab9;

import java.util.*;
import java.util.stream.*;

public class PatrateDistincte {
    public static void main(String[] args) {
        List<Integer> numere = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
        List<Integer> patrateDistincte = numere.stream()
                .distinct()
                .map(n -> n * n)
                .collect(Collectors.toList());

        System.out.println("Lista inițială: " + numere);
        System.out.println("Pătratele valorilor distincte: " + patrateDistincte);
    }
}
