package com.home;

import java.util.Scanner;

public class Task9 {
    public static void main(String[] args) {
/*    Создайте программу, которая выведет на экран числа фибоначи до указанного числа.
    Число должно приходить в аргументах 	Ввод: 50
    Вывод: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34    */
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int next = 1;
        int back = 0;
        int trans = 0;
        System.out.print(back + ", " + next + ", ");
        do {
            trans = next;
            next = next + back;
            if (next < n) {
                System.out.print(next);
                if ((trans + next) < n) System.out.print(", ");
                else System.out.print(" ");
            }
            back = trans;
        } while (next < n);
    }
}