package com.home;

public class Task10 {
/*    Напишите генератор случайных чисел (от 1 до 7), выведите день недели
соответствующий числу 	Вывод: 1 - Понедельник 3 - Среда */
    public static void main(String[] args) {
        String arrDayWeek[] = {"Понедельник", "Вторник", "Среда", "Четверг",
                "Пятница", "Суббота", "Воскресенье"};
            int i = (int) (Math.random() * 7);
            System.out.println(i+1 + " - " + arrDayWeek[i]);
    }
}
