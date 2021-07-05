package ru.markvero.cell;

import ru.markvero.gamers.Human;
import ru.markvero.gamers.PC;

import java.util.Arrays;
import java.util.Scanner;

public class Cell {
    // Здесь вычисляем состояние ячеек
    public static String[][] field = {
            {"_", "_", "_"},
            {"_", "_", "_"},
            {"_", "_", "_"}
    };

    private static int[][] num;

    {
        num = new int[][]{
                {1, 1, 1},
                {2, 2, 2},
                {3, 3, 3}};
    }

    public void post() {
        System.out.print("    |");
        System.out.println("\tA\tB\tC");
        System.out.print("----+");
        for (int u = 0; u < 3; u++) {
            System.out.print("----");
        }
        System.out.println();
        int i, j;
        for (i = 0; i < 3; i++) {
            System.out.printf("%3d |", i + 1);
            for (j = 0; j < 3; j++) {
                System.out.print("\t" + field[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static String findWin() {
        // pc ищет клетку для победы
        String choiseW = "O";
        String reserved = "O";
        int countSv = 0; // количество свободных ("_") ячеек
        String[] arrSv;
        arrSv = new String[9];
//        Arrays.stream(field).map(Arrays::toString).forEach(System.out::println);
        int i, j;
        for (i = 0; i < 3; i++)
            for (j = 0; j < 3; j++) {

                if (field[i][j] == "_") {
                    String nameQ = named(i, j);
                    reserved = nameQ;
                    arrSv[countSv] = nameQ;
                    countSv++;
//                    System.out.println("countSv =" + countSv);
                }

                if (field[i][j] == "O")  {
                    String nameQ = named(i, j);
//                    reserved = nameQ;
                    if ((nameQ == "A1") & (field[1][1] == "_")) {
                        choiseW = "B2";
                        break;
                    }
                    if ((nameQ == "A1") & (field[1][0] == "_")) {
                        choiseW = "A2";
                        break;
                    }
                    if ((nameQ == "A1") & (field[0][1] == "_")) {
                        choiseW = "B1";
                        break;
                    }
                    if ((nameQ == "A2") & (field[2][0] == "_")) {
                        choiseW = "A3";
                        break;
                    }
                    if ((nameQ == "A2") & (field[0][0] == "_")) {
                        choiseW = "A1";
                        break;
                    }
                    if ((nameQ == "A2") & (field[1][1] == "_")) {
                        choiseW = "B2";
                        break;
                    }
                    if ((nameQ == "A3") & (field[0][1] == "_")) {
                        choiseW = "B1";
                        break;
                    }
                    if ((nameQ == "A3") & (field[2][1] == "_")) {
                        choiseW = "B3";
                        break;
                    }
                    if ((nameQ == "B1") & (field[1][1] == "_")) {
                        choiseW = "B2";
                        break;
                    }
                    if ((nameQ == "B1") & (field[0][0] == "_")) {
                        choiseW = "A1";
                        break;
                    }
                    if ((nameQ == "B1") & (field[0][2] == "_")) {
                        choiseW = "C1";
                        break;
                    }
                    if ((nameQ == "B2") & (field[2][1] == "_")) {
                        choiseW = "B3";
                        break;
                    }
                    if ((nameQ == "B2") & (field[1][2] == "_")) {
                        choiseW = "C2";
                        break;
                    }
                    if ((nameQ == "B3") & (field[2][2] == "_")) {
                        choiseW = "C3";
                        break;
                    }
                    if ((nameQ == "B3") & (field[2][0] == "_")) {
                        choiseW = "A3";
                        break;
                    }
                    if ((nameQ == "B3") & (field[1][1] == "_")) {
                        choiseW = "B2";
                        break;
                    }
                    if ((nameQ == "C1") & (field[1][2] == "_")) {
                        choiseW = "C2";
                        break;
                    }
                    if ((nameQ == "C2") & (field[2][2] == "_")) {
                        choiseW = "C3";
                        break;
                    }
                }
            }
        if (choiseW == "O")
            if (reserved != "O") {
                int x = (int) (Math.random()*countSv);
//                System.out.println("Random");
                choiseW = arrSv[x];
            }
            else {
                if (countSv == 0) {
                    System.out.println("Ничья! Вариантов больше нет!");
                    System.exit(0);
                }
            }
        return choiseW;
    }

    public static String named(int i, int j) {
        String name = "";
        if ((i == 0) & (j == 0)) name = "A1";
        if ((i == 1) & (j == 0)) name = "A2";
        if ((i == 2) & (j == 0)) name = "A3";
        if ((i == 0) & (j == 1)) name = "B1";
        if ((i == 1) & (j == 1)) name = "B2";
        if ((i == 2) & (j == 1)) name = "B3";
        if ((i == 0) & (j == 2)) name = "C1";
        if ((i == 1) & (j == 2)) name = "C2";
        if ((i == 2) & (j == 2)) name = "C3";
        return name;
    }

    public static void drawChoise(String choise, String who, String field[][]) {
        System.out.print("    |");
        System.out.println("\tA\tB\tC");
        System.out.print("----+");
        for (int u = 0; u < 3; u++) {
            System.out.print("----");
        }
        System.out.println(" ");
        String dr;
        if (who == "human") dr = "X";
        else dr = "O";

        switch (choise) {
            case "A1":
                field[0][0] = dr;
                break;
            case "A2":
                field[1][0] = dr;
                break;
            case "A3":
                field[2][0] = dr;
                break;
            case "B1":
                field[0][1] = dr;
                break;
            case "B2":
                field[1][1] = dr;
                break;
            case "B3":
                field[2][1] = dr;
                break;
            case "C1":
                field[0][2] = dr;
                break;
            case "C2":
                field[1][2] = dr;
                break;
            case "C3":
                field[2][2] = dr;
                break;
        }

        int i, j;
        for (i = 0; i < 3; i++) {
            System.out.printf("%3d |", i + 1);
            for (j = 0; j < 3; j++) {
                System.out.print("\t" + field[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("____________________________");
//        for (int m = 0; m < 50; ++m) System.out.println();
        // проверка условия победы
        if(isWin(who) == "win") {
            if (who == "human")
            System.out.println("Вы победили!");
            else System.out.println("Компьютер победил!");
            System.exit(0);
        }
        // передача хода
        if (who == "human") {
            PC.pcMove();
        } else {
            Human.humanChoise();
        }

    }

    public static String isWin(String who) {
//        System.out.println("isWin");
        String W = "";
        String che;
        int a1 = 0;
        int a2 = 0;
        int a3 = 0;
        int b1 = 0;
        int b2 = 0;
        int b3 = 0;
        int c1 = 0;
        int c2 = 0;
        int c3 = 0;
        if (who == "human") {
            che = "X";
        } else che = "O";
        int i, j;
        for (i = 0; i < 3; i++)
            for (j = 0; j < 3; j++) {
                if (field[i][j] == che) {
                    if ((i == 0) & (j == 0)) a1 = 1;
                    if ((i == 1) & (j == 0)) a2 = 1;
                    if ((i == 2) & (j == 0)) a3 = 1;
                    if ((i == 0) & (j == 1)) b1 = 2;
                    if ((i == 1) & (j == 1)) b2 = 2;
                    if ((i == 2) & (j == 1)) b3 = 2;
                    if ((i == 0) & (j == 2)) c1 = 3;
                    if ((i == 1) & (j == 2)) c2 = 3;
                    if ((i == 2) & (j == 2)) c3 = 3;
                }
        }
//        System.out.println(a1+" "+a2+" "+a3+" "+b1+" "+b2+" "+b3+" "+c1+" "+c2+" "+c3);
        if ((a1+a2+a3) == 3) W = "win";
        if (((a1+b1+c1) == 6) | ((a1+b2+c3) == 6) | ((a2+b2+c2) == 6)) W = "win";
        if (((a3+b2+c1) == 6) | ((b1+b2+b3) == 6)) W = "win";
        if ((c1+c2+c3) == 9) W = "win";
//        System.out.println("W = " + W);
        return W;
    }

    public static String checkPcWin() {
        // pc проверяет, есть ли клетка, которая приведет человека к победе
        String check = "O";
        int a1 = 0;
        int a2 = 0;
        int a3 = 0;
        int b1 = 0;
        int b2 = 0;
        int b3 = 0;
        int c1 = 0;
        int c2 = 0;
        int c3 = 0;
        int i, j;
        for (i = 0; i < 3; i++)
            for (j = 0; j < 3; j++) {
                if (field[i][j] == "X") {
                    if ((i == 0) & (j == 0)) a1 = 1;
                    if ((i == 1) & (j == 0)) a2 = 1;
                    if ((i == 2) & (j == 0)) a3 = 1;
                    if ((i == 0) & (j == 1)) b1 = 2;
                    if ((i == 1) & (j == 1)) b2 = 2;
                    if ((i == 2) & (j == 1)) b3 = 2;
                    if ((i == 0) & (j == 2)) c1 = 3;
                    if ((i == 1) & (j == 2)) c2 = 3;
                    if ((i == 2) & (j == 2)) c3 = 3;
                }
            }
        if (((a1+a2) == 2) | ((a2+a3) == 2) | ((a1+a3) == 2)) {
            if (field[0][0] == "_") check = "A1";
            if (field[1][0] == "_") check = "A2";
            if (field[2][0] == "_") check = "A3";
        };
        if (((a1+b1) == 3) | ((b1+c1) == 5)| ((a1+c1) == 4)) {
            if (field[0][0] == "_") check = "A1";
            if (field[0][1] == "_") check = "B1";
            if (field[0][2] == "_") check = "C1";
        };
        if (((a1+b2) == 3) | ((b2+c3) == 5)| ((a1+c3) == 4)) {
            if (field[0][0] == "_") check = "A1";
            if (field[1][1] == "_") check = "B2";
            if (field[2][2] == "_") check = "C3";
        };
        if (((a2+b2) == 3) | ((b2+c2) == 5)| ((a2+c2) == 4)) {
            if (field[1][0] == "_") check = "A2";
            if (field[1][1] == "_") check = "B2";
            if (field[1][2] == "_") check = "C2";
        };
        if (((a3+b2) == 3) | ((b2+c1) == 5)| ((a3+c1) == 4)) {
            if (field[2][0] == "_") check = "A3";
            if (field[1][1] == "_") check = "B2";
            if (field[0][2] == "_") check = "C1";
        };
        if (((b1+b2) == 4) | ((b2+b3) == 4)) {
            if (field[0][1] == "_") check = "B1";
            if (field[1][1] == "_") check = "B2";
            if (field[2][1] == "_") check = "B3";
        };
        if (((c1+c2) == 6) | ((c2+c3) == 6)) {
            if (field[0][2] == "_") check = "C1";
            if (field[1][2] == "_") check = "C2";
            if (field[2][2] == "_") check = "C3";
        };
        return check;
    }

}
