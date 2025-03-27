package lab4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

class Student
{
    String nume;
    String grupa;
    List<Integer> note;

    public Student(String name, String grupa)
    {
        this.nume = nume;
        this.grupa = grupa;
        this.note = new ArrayList<>();
    }

    public double getMedie()
    {
        return note.stream().mapToInt(Integer::intValue).average().orElse(0);
    }

    public String getGrupa()
    {
        return this.grupa;
    }

    public int getNumarRestante()
    {
        return (int) note.stream().filter(n -> n < 5).count();
    }

    @Override
    public String toString()
    {
        return nume + " - " + grupa + " - " + note + " - Medie: " + String.format("%.2f", getMedie());
    }
}

public class DoileaExercitiu
{
    public static void main(String[] args)
    {
        List<Student> studenti = new ArrayList<>();
        Random rand = new Random();

        studenti.add(new Student("Popescu Andrei", "TI21_2"));
        studenti.add(new Student("Alexandru Ion", "TI21_2"));
        studenti.add(new Student("Gheorghe Pintilie", "TI21_2"));
        studenti.add(new Student("Marinescu Marius", "TI21_2"));

        for (Student s : studenti)
        {
            for (int i = 0; i < 5; i++)
            {
                s.note.add(rand.nextInt(7) + 4);
            }
        }

        // b1)
        studenti.sort(Comparator.comparing(Student::getGrupa).thenComparing(s -> s.nume));
        System.out.println("Sortarea alfabetica pentru grupe: " );
        studenti.forEach(System.out::println);

        // b2)
        System.out.println("\nIntegralisti prin sortare descrescatoare dupa medie: ");
        studenti.stream().filter(s -> s.getNumarRestante() == 0).sorted(Comparator.comparingDouble(Student::getMedie).reversed()).forEach(System.out::println);


    }
}
