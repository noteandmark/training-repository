package com.home;

public class Task13 {
/*    Напишите программу, которая посчитает среднее значение в массиве положительных
 чисел. Проверьте работу программы на нескольких массивах
    Ввод: [1, 2, 7, 30, 5, 70, 44]
    Вывод: 22.714*/
public static void main(String[] args) {
    int arr[] = {1, 2, 7, 30, 5, 70, 44};
    double sum = 0;
    for (int c : arr) {
        sum+= c;
    }
    sum /= arr.length;
    System.out.printf("%.3f",sum);
}
}
