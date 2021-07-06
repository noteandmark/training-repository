package com.home;

import java.util.Arrays;

public class Task12 {
    /*    Напишите программу, которая отсортирует массив по возрастанию.
          Проверьте работу программы на нескольких массивах
        Ввод: [24, 13, -1, 2, 4, 70, 44]
        Вывод: [-1, 2, 4, 13, 24, 44, 70]*/
    public static void main(String[] args) {
        int arr[] = {24, 13, -1, 2, 4, 70, 44};
        int temp = 0;
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    isSorted = false;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
}
}
