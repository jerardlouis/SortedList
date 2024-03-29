package sample;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
/*
//Original Main
        Random rand = new Random(1);
        SortedList<Integer> list = new SortedList<Integer>();
        int m = args.length == 1 ? Integer.parseInt(args[0]) : 10;

        System.out.println("insert");
        for (int i = 0; i < m; ++i) {
            int n = rand.nextInt(m);
            list.insert(n);
            System.out.print(n + ": ");
            for (Integer j : list) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        rand = new Random(1);


        System.out.println("search");
        for (int i = 0; i < m; ++i) {
            int n = rand.nextInt(m);
            //list.search(n);
            System.out.print(n + ": ");
            list.search(n);
        }

        rand = new Random(1);

        System.out.println("retrieve");
        for (int i = 0; i < m; ++i) {
            //int n = rand.nextInt(m);
            System.out.println(list.retrieve(i));
        }

        rand = new Random(1);

        System.out.println("remove");
        for (int i = 0; i < m; ++i) {
            int n = rand.nextInt(m);
            list.remove(n);
            System.out.print(n + ": ");
            for (Integer j : list) {
                System.out.print(j + " ");
            }
            System.out.println();

        }
*/

//Kap main
        Random rand = new Random(1);
        SortedList<Integer> list = new SortedList<Integer>();
        int num = args.length == 1 ? Integer.parseInt(args[0]) : 10;
        long start, stop;

        System.out.println("insert");
        start = System.currentTimeMillis();
        for (int i = 0; i < num; ++i) {
            list.insert(rand.nextInt(num));
            System.out.print(i + ": ");
            for (int j : list) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        rand = new Random(1);
        System.out.println("remove");

        for (int i = 0; i < num; ++i) {
            int n = rand.nextInt(num);
            list.remove(n);
            System.out.print(n + ": ");
            for (Integer j : list) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        stop = System.currentTimeMillis();

        System.out.println(stop-start);
        for (int i = 0; i < num; ++i) {
            list.insert(rand.nextInt(num));
        }
        int j;
        for (int i = 0; list.retrieve(i) != null; ++i) {
            System.out.println((j = list.retrieve(i)) + " => " + list.search(j));
        }

        for (int i = 0; i < num; ++i) {
            System.out.println(i + " => " + list.search(i));
        }
        //end here
    }

}