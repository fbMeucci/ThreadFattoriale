package it.thread;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Calcolo di C(n,k) tramite il ");
        System.out.println("Calcolo dei 3 fattoriali: n! k! (n-k)!");
        System.out.println("Valore di n");
        long n = input.nextLong();
        System.out.println("Valore di k");
        long k = input.nextLong();
        input.close();
        ThreadFattoriale t1 = new ThreadFattoriale(n, "FATT(" + n + ")");
        ThreadFattoriale t2 = new ThreadFattoriale(k, "FATT(" + k + ")");
        ThreadFattoriale t3 = new ThreadFattoriale(n - k, "FATT(" + (n - k) + ")");
        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long fatt = t1.getFatt() / (t2.getFatt() * t3.getFatt());
        System.out.println("C(" + n + "," + k + ") = " + fatt);
    }
}