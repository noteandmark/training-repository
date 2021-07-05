package ru.markvero.cell;

import ru.markvero.gamers.Human;
import ru.markvero.cell.Cell;
import ru.markvero.gamers.PC;

import java.util.Scanner;

import static java.lang.Math.random;
import static java.lang.Thread.sleep;

// запускается при старте игры
public class Start {

    public void firstMove() throws InterruptedException {
        System.out.println(" ");
        // отображаем поле игры
        Cell cell = new Cell();
        cell.post();
        // определяем, кто ходит первым
        System.out.println();
        System.out.println("Бросаем монетку, чтобы определить, кто ходит первым...");
        int right = (int) (Math.random() * 2);
        sleep(2000);
        if (right == 0) {
        System.out.println("Первым ходит игрок");
        Human human = new Human();
//        human.humanChoise();
        Scanner scanner = new Scanner(System.in);
        boolean correct = false;
        do {
            human.choise = human.setChoise(scanner.nextLine());
            switch (human.choise) {
                case "A1":
                case "A2":
                case "A3":
                case "B1":
                case "B2":
                case "B3":
                case "C1":
                case "C2":
                case "C3":
                    correct = true;
                    break;
                default:
                    System.out.println("Введите правильный номер ячейки");
                    correct = false;
                    break;
            }
        } while (correct == false);

        cell.drawChoise(human.choise, "human", cell.field);
        }
        else {
            System.out.println("Первым ходит компьютер");
            PC pc = new PC();
            pc.pcMove();
        }

    }

}
