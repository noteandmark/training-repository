package com.home;

import java.util.HashMap;
import java.util.HashSet;

public class Task16 {
    /*    Напишите программу, которая найдет дубликаты в массиве чисел.
    Проверьте работу программы на нескольких массивах
        Ввод: [1, 2, 2, 30, 5, 70, 44, 30]
        Вывод: [2, 30]*/
    public static void main(String[] args) {
        int arr[] = {1, 2, 2, 30, 5, 70, 44, 30};
        HashSet<Integer> h = new HashSet<Integer>();
        for (int n = 0; n < arr.length; n++) {
            if (!h.add(arr[n])) {
                System.out.print(arr[n]);
                if (n!=arr.length-1) System.out.print(", ");
            }
        }
    }
}
