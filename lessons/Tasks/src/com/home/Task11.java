package com.home;

import java.util.Scanner;

public class Task11 {
/*    Создайте программу, которая будет выводить числа последовательно в виде
треугольника (floyd triangle). Число должно приходить в аргументах, пример вывода
в следующей колонке
    Ввод: 5
    Вывод:
            1
            2 3
            4 5 6
            7 8 9 10
            11 12 13 14 15*/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int x = 1;
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= num; j++) {
                if (j <= i) {
                    System.out.print(x + " ");
                    x++;
                }
            }
            System.out.println();
        }
    }
}
