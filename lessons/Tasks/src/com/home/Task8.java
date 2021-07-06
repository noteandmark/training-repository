package com.home;

public class Task8 {
    //    Создайте программу, которая выведет на экран таблицу умножения
    public static void main(String[] args) {

        System.out.println ("\t\t\t Таблица умножения");
        System.out.println();
        System.out.print("    |");
        System.out.println("\t1\t2\t3\t4\t5\t6\t7\t8\t9");

        System.out.print("----+");
        for (int u=0; u<9; u++) {
            System.out.print("----");
        }
        System.out.println(" ");

        for(int q=1; q<=9; q++) {
            System.out.printf("%3d |", q);

            for (int m=1; m<=9; m++) {
                //System.out.printf(q*m + "   ");
                System.out.printf("%4d", q*m);
            }
            System.out.println();
        }
    }
}