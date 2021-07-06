package com.home;

import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
    // Задача: Создайте массив чисел и выведите этот массив на экран Вывод: 1,2,3,4,7,15
    int[] num = new int[] {1,2,3,4,7,15};
    for (int i = 0; i < 6; i++) {
        if (i < 5)
            System.out.print(num[i] + ",");
        else
            System.out.println(num[i]);
    }
    // Создание массива с любым количеством чисел
    int[] a;
    int n;
    Scanner in = new Scanner(System.in);
    System.out.println("Enter numbers of array: ");
    n = in.nextInt();
    a = new int[n];
    for (int i = 0; i < n; i++) {
        System.out.print("Enter a[" + i + "] = ");
        a[i] = in.nextInt();
    }
    for (int i = 0; i < n; i++) {
        if (i < n-1)
            System.out.print(a[i] + ",");
        else
            System.out.println(a[i]);
    }
    }
}
