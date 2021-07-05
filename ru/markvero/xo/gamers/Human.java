package ru.markvero.gamers;

import ru.markvero.cell.Cell;

import java.util.Scanner;

import static ru.markvero.cell.Cell.field;

public class Human {
    public String choise = "N/A";

    public static void humanChoise() {
        Scanner scanner = new Scanner(System.in);
        boolean correct = false;
        String choiseN;
        do {
            System.out.println("Ваш ход:");
            choiseN = setChoise(scanner.nextLine());
//            choiseN = this.choise;
            switch (choiseN) {
                case "A1":
                    if (field[0][0] == "_") {
                        correct = true;
                        break;
                    }
                case "A2":
                    if (field[1][0] == "_") {
                        correct = true;
                        break;
                    }
                case "A3":
                    if (field[2][0] == "_") {
                        correct = true;
                        break;
                    }
                case "B1":
                    if (field[0][1] == "_") {
                        correct = true;
                        break;
                    }
                case "B2":
                    if (field[1][1] == "_") {
                        correct = true;
                        break;
                    }
                case "B3":
                    if (field[2][1] == "_") {
                        correct = true;
                        break;
                    }
                case "C1":
                    if (field[0][2] == "_") {
                        correct = true;
                        break;
                    }
                case "C2":
                    if (field[1][2] == "_") {
                        correct = true;
                        break;
                    }
                case "C3":
                    if (field[2][2] == "_") {
                        correct = true;
                        break;
                    }
                default:
                    System.out.println("Введите правильный номер ячейки");
                    correct = false;
                    break;
            }
        } while (correct == false);

        Cell.drawChoise(choiseN, "human", field);
    }

    public static String setChoise(String choise) {
//        this.choise = choise;
        return choise;
    }
}
