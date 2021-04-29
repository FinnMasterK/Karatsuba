package com.company;

public class Main {

    public static long Karatsuba(long i, long j){
        if (i < 10 || j < 10)
            return i*j;
        double n = getLength(Math.max(i,j));
        if (n%2 == 1)
            n++;
        long a = (long) (i/Math.pow(10,(n/2)));
        long b = (long) (i%Math.pow(10,(n/2)));
        long c = (long) (j/Math.pow(10,(n/2)));
        long d = (long) (j%Math.pow(10,(n/2)));

        long fr = Karatsuba(a, c);
        long sc = Karatsuba(b, d);
        long trd = Karatsuba(a + b, c + d);

        return ((long) ((fr * Math.pow(10, n)) + ((trd - fr - sc) * Math.pow(10, (n/2))) + sc));
    }

    public static int getLength( long a){
        String b = Long.toString(a);
        return b.length();
    }

    public static void main(String[] args) {
        long a = 4356145;
        long b = 635736521;
        System.out.print(a + " * " + b +" = ");
        System.out.println(Karatsuba(a,b));
    }
}
