package Zusatzaufgaben_Programmieren1;            // Meine Lösung

import java.util.*;
import java.util.stream.Collectors;

public class Eratosthenes {
    //a
    public static int[] fillArray(int upperBound) { // Wenn alles auf englisch ist, dann benenne deine Variablen am Besten auch englisch
        var result = new int[upperBound + 1]; // Ich hab hier mal die 0 auch als natürliche Zahl aufgenommen. Weiß nicht, ob das ok ist.
        Arrays.setAll(result, id -> id);
        return result;
    }

    // b
    public static int[] sieve(int[] array) {

        int maxTest = (int) Math.sqrt(array.length);
        array[0] = -1; // 0 und 1 sind per Definition keine Primzahlen
        array[1] = -1;

        for (int i = 2; i <= maxTest; i++) {
            if (array[i] == -1) continue; // Wenn die Zahl schon als Primzahl erkannt wurde, soll sie nicht als Faktor für den Test benutzt werden
            for (int j = 2*i; j < array.length; j+=i) // Mit der Schrittweite (j+=i) nehmen wir automatisch nur die Vielfachen von i mit
                array[j] = -1;
        }

        return array;
    }

    // c
    public static void showContent(int[] array){
        for (int i = 0; i<array.length; i++)
            System.out.printf(
                "%d is %sa prime number%n", 
                i, 
                array[i]==-1 ? "not ": ""
            );
    }

    public static void showPrimesOnly(int[] array) {
        System.out.println(
            Arrays
                .stream(array)
                .filter(n -> n > 0)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(", "))
        );
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Test numbers: ");
        int upperBound = sc.nextInt();

        var array = sieve(fillArray(upperBound));
        showContent(array);

        System.out.println("\nPrimes only:");
        showPrimesOnly(array);  // Testweise nur die Primzahlen anzeigen (ist übersichtlicher)
        sc.close();
    }
}
