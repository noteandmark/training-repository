/**
 *  Игра "Крестики-Нолики"
 *  Играет человек с компьютером
 *  Создана: 2021г
 *  Версия: 1.0
 */
package ru.markvero;

import ru.markvero.cell.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Приветствую в игре \"Крестики-Нолики\"");
        Start first = new Start();
        first.firstMove();
    }
}