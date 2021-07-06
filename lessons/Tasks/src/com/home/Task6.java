package com.home;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Task6 {
// Задача:
//Создайте программу, которая переводит температуру в Фарингейтах
// в температуру по цельсию	Ввод: 41 Вывод: 5
public static void main(String[] args) {
    System.out.println("Enter temperature in Fahrenheit");
    Scanner tF = new Scanner(System.in);
    float F = tF.nextFloat();
    float C = (float) ((F-32)/1.8);
    DecimalFormat tC = new DecimalFormat("#.0");
    System.out.println("Temperature in Celsius = " + tC.format(C));
}
}
