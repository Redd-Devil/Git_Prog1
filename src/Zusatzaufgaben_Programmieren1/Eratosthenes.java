package Zusatzaufgaben_Programmieren1;            // Meine Lösung

import java.util.Scanner;

public class Eratosthenes {

        public static int oberGrenze;

    //a
    public static int[] fillArray(int oberGrenze) {
        int[] arg1 = new int[oberGrenze];

        for (int i = 0; i < arg1.length; i++) {
            arg1[i] = i + 1;
        }
        return arg1;
    }

    // b
    public static int[] sieve(int[] arg2) {

        int grenze = (int) Math.sqrt(oberGrenze);
        arg2[0] = -1;

        for (int i = 2; i <= grenze; i++) {
            for (int j = 2; j < oberGrenze; j++)
                if (arg2[j] % i == 0) arg2[j] = -1;
        }

        return arg2;
    }

    // c
    public static void showContent(int[] arg3){

        System.out.println("0 is not a prime number");

        for (int i = 0; i < oberGrenze; i++) {
        if(arg3[i] == -1) System.out.println(i + 1 + " is not a prime number");
        else System.out.println(arg3[i] + " is a prime number");
        }
    }
        public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Test numbers: ");
        oberGrenze = sc.nextInt();
        showContent(sieve(fillArray(oberGrenze)));              // 3 Methoden ineinander verschachtelt
    }
}
