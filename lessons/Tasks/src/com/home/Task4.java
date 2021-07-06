package com.home;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) throws IOException {
        // решаем задачу через Scanner
        Scanner num = new Scanner(System.in);
        int a, b;
        String it;

        System.out.println("Это программа для математических действий над 2 числами");
        System.out.println("Введите первое число");
        a = num.nextInt();

        System.out.println("Введите второе число");
        b = num.nextInt();

        System.out.println("Введите операцию: sum - сложить; sub - вычесть; mul - умножить; div - разделить числа");
        it = num.next();

        /*
        // решаем задачу с вводом чисел с помощью BufferedReader
        System.out.println("Это программа для математических действий над 2 числами");
        System.out.println("Введите первое число");
        BufferedReader reader_a = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader_a.readLine());

        System.out.println("Введите второе число");
        BufferedReader reader_b = new BufferedReader(new InputStreamReader(System.in));
        int b = Integer.parseInt(reader_b.readLine());

        System.out.println("Введите операцию: sum - сложить; sub - вычесть; mul - умножить; div - разделить числа");
        BufferedReader reader_it = new BufferedReader(new InputStreamReader(System.in));
        String it = reader_it.readLine();
        */
        float itog;
        if (it.equals("sum")) {
            itog = a + b;
            System.out.println("Сумма:" + itog);
        }
        if (it.equals("sub")) {
            itog = a - b;
            System.out.println("Вычли:" + itog);
        }
        if (it.equals("mul")) {
            itog = a * b;
            System.out.println("Умножили:" + itog);
        }
        if (it.equals("div")) {
            itog = (float) (a) / (float) (b);
            System.out.println("Разделили:" + itog);
        }

        // Ниже приведен метод решения задачи с заданием аргументов через командную строку при запуске
        /*
        if (args.length != 3)
            System.out.println("Введите два числа и название операции (sum)");
        else {
            for (int i = 0; i < args.length; i++) {
                System.out.println("Аргумент №" + i + ": args[" + i + "]=" + args[i]);
            }
               sum - сумма
               sub - вычитать
               mul - умножать
               div - делить

            if (args[2].equals("sum")) {
                int a = Integer.parseInt(args[0]);
                int b = Integer.parseInt(args[1]);
                int itog = a + b;
                System.out.println("Сложили (sum) = " + itog);
            }
            if (args[2].equals("sub")) {
                int a = Integer.parseInt(args[0]);
                int b = Integer.parseInt(args[1]);
                int itog = a - b;
                System.out.println("Вычли (sub) = " + itog);
            }
            if (args[2].equals("mul")) {
                int a = Integer.parseInt(args[0]);
                int b = Integer.parseInt(args[1]);
                int itog = a * b;
                System.out.println("Умножили (mul) = " + itog);
            }
            if (args[2].equals("div")) {
                int a = Integer.parseInt(args[0]);
                int b = Integer.parseInt(args[1]);
                int itog = a / b;
                System.out.println("Разделили (div) = " + itog);
            }
        }
         */
    }
}
