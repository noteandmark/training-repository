package ru.markvero.gamers;

import ru.markvero.cell.Cell;

import static ru.markvero.cell.Cell.field;

public class PC {

    // ход компьютера
    public static void pcMove() {
        int i, j;
        boolean start = true;
        String choise;
        for (i = 0; i < 3; i++)
            for (j = 0; j < 3; j++) {
                if (field[i][j] != "_") start = false;
            }
        if (start == true) {
            int s;
            s = (int) (Math.random() * 9);
            switch (s) {
                case 0:
                    choise = "A1";
                    break;
                case 1:
                    choise = "A2";
                    break;
                case 2:
                    choise = "A3";
                    break;
                case 3:
                    choise = "B1";
                    break;
                case 4:
                    choise = "B2";
                    break;
                case 5:
                    choise = "B3";
                    break;
                case 6:
                    choise = "C1";
                    break;
                case 7:
                    choise = "C2";
                    break;
                case 8:
                    choise = "C3";
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + s);
            }
            ru.markvero.cell.Cell.drawChoise(choise, "cpu", field);
        }
        // если уже не старт - ищем, куда лучше компьютеру поставить свой нолик )
        else {
            // проверка на то, есть ли опасность, что игрок выиграет - тогда блокируем ему клетку
            String check;
            check = Cell.checkPcWin();
            if (check == "O") {
                check = Cell.findWin();
            }
            System.out.println("Компьютер ходит " + check + " :");
            Cell.drawChoise(check, "cpu", field);
        }
    }
}
