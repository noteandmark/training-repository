package com.home;

import java.util.Arrays;

public class Task15 {
/*    Напишите программу, которая инвертирует массив (значения должны идти в
обратном порядке). Проверьте работу программы на нескольких массивах
    Ввод: [1, 2, 7, 30, 5, 70, 44]
    Вывод: [44, 70, 5, 30, 7, 2, 1]            */
public static void main(String[] args) {
    int arr[] = {1, 2, 7, 30, 5, 70, 44};
    int temp;
    int n = (arr.length%2 == 0) ? arr.length/2 - 1: arr.length/2;
    int m = arr.length - 1;
    System.out.println("n=" + n);
    for (int i = 0; i < n; i++) {
        temp = arr[i];
        arr[i] = arr[m-i];
        arr[m-i] = temp;
    }
    System.out.println(Arrays.toString(arr));
}
}
