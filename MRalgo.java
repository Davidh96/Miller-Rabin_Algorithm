package com.thedavehunt.millerrabin;

import java.util.Random;
import java.util.Scanner;

public class MRalgo {


    public static void main(String args[]){
        int n;
        System.out.println("Enter in a number to check for primality: ");

        Scanner inputScan = new Scanner(System.in);
        n = inputScan.nextInt();

        if(n%2!=0) {
            millerrabin(n);
        }
        else{
            System.out.println(n + " is not prime");
        }

        System.out.println("miller-rabin complete");

    }

    private static void millerrabin(int n) {
        //n-1=2^k*m
        System.out.println("miller-rabin running");

        double tempm = 0;
        int m = 1;
        int k = 1;
        boolean primality=false;
        int a;
        double b,b2;

        Random rand = new Random();
        //1 <a <n-1
        a = rand.nextInt((int)(n-1));


        while (true) {
            //calculate m
            tempm = (n - 1) / Math.pow(2, k);
            //checks to see if number is a whole number
            if (tempm%1!=0) {
                //if whole break from loop
                break;
            }
            //place tempm into m
            m = (int)tempm;
            k++;

        }
        System.out.println("k:" + k + " m:" + m);

        a=2;

        //b=a^m mod n
        b = Math.pow(a, m) % n;

        //first round
        if (b == 1) {
            System.out.println(n + " is Prime");
        }
        //following round
        else {
            //loop until reach k-1
            for (int j = 0; j < k - 1; j++) {
                //a^2^j*m mod n
                b2 = Math.pow(a, (Math.pow(2, j) * m)) % n;
                if ( b2== n - 1) {
                    System.out.println(n + " is  Prime");
                    primality = true;
                }
            }
            if (!primality) {
                System.out.println(n + " is not Prime");
            }
        }
    }
}

