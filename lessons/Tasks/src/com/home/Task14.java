package com.home;

public class Task14 {
/*    Напишите программу, которая посчитает min и max значение в массиве.
    Проверьте работу программы на нескольких массивах
    Ввод: [24, 13, -1, 2, 4, 70, 44]
    Вывод: min = -1, max = 70 */
public static void main(String[] args) {
    int arr[] = {24, 13, -1, 2, 4, 70, 44};
    int min = arr[0];
    int max = arr[0];
    for (int i = 1; i < arr.length - 1; i++) {
        if (max < arr[i]) {
            max = arr[i];
        }
        if (min > arr[i]) {
            min = arr[i];
        }
    }
    System.out.println("min =" + min);
    System.out.println("max =" + max);
}
}
