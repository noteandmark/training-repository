package com.home;

import java.util.Scanner;

public class Task7 {
//    Создайте программу, которая принимает целое число и суммирует его цифры.
//    Число должно приходить в аргументах. Ввод: 123 Вывод: 6

    public static void main(String[] args) {
        Scanner myInput = new Scanner(System.in);
        System.out.println("Введите целое число. Программа суммирует его цифры.");
        String input = myInput.next();
        int sum = 0;
        for (int i = 0; i < input.length(); i++) {
            int a = Character.getNumericValue(input.charAt(i));
            sum += a;
        }
        System.out.println("Сумма всех цифр числа = " + sum);
    }

}
