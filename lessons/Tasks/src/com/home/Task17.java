package com.home;

import java.util.*;

public class Task17 {
    /*    Напишите программу, которая найдет пересечение в двух массивах чисел.
        Проверьте работу программы на нескольких массивах
        Ввод: [1, 2, 7, 30, 5, 70, 44] , [1, 4, 17, 30, 28, 99]
        Вывод: [1, 30]*/
    public static void main(String[] args) {
        int arr1[] = {1, 2, 7, 30, 5, 70, 44};
        int arr2[] = {1, 4, 17, 30, 28, 99};
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet();

        for (int n = 0; n < arr1.length; n++) {
            set1.add(arr1[n]);
        }

        for (int n = 0; n < arr2.length; n++) {
            set2.add(arr2[n]);
        }

        set1.retainAll(set2);

        System.out.println(set1);
    }
}