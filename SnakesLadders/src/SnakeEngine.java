import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SnakeEngine implements ActionListener {
    private int player1 = 0;
    private int player2 = 0;
    private int turnPlayer = 0;
    private int intX;
    private int intY;
    private String turnPlayerName;
    private Boolean win = false;
    private Point conusPointPlayer1 = new Point(0, 0);
    private Point conusPointPlayer2 = new Point(0, 0);
    private Color pl = Color.BLUE;
    MyGUI gui;

    SnakeEngine(MyGUI gui) {
        this.gui = gui;
        int n = (int) (Math.random() * 2);
        turnPlayerName = (n == 0) ? "Первый" : "Второй";
        turnPlayer = n + 1;
        checkColor();
        gui.pane.appendtoPane(gui.pane, "Начинает игрок " + turnPlayerName + "\n", pl);
        if (!gui.withHuman.isSelected() && turnPlayer == 2) {
            movePC();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == gui.button) {
            if (!gui.withRCube.isSelected()) {
                move(0);
            } else {
                boolean digit = false;
                JFrame dialog = new JFrame("Введите число от 1 до 6");
                while (!digit) {
                    try {
                        int dice = Integer.parseInt(JOptionPane.showInputDialog(dialog, "Сколько на кубике выпало?"));
                        if (dice > 0 && dice < 7) {
                            digit = true;
                            move(dice);
                        } else {
                            JOptionPane.showMessageDialog(new JFrame(), "Введите число от 1 до 6 !");
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
    }

    public void movePC() {
        gui.button.setEnabled(false);

    }

    public void checkColor() {
        if (turnPlayer == 1) pl = Color.GREEN;
        else pl = Color.RED;
    }

    public void move(int number) {
        Point temp;
        int cell = 0;
        if (number == 0) {
            number = (int) (Math.random() * 6 + 1);
        }
        checkColor();
        gui.pane.appendtoPane(gui.pane, "Выпало: " + String.valueOf(number) + "\n", pl);
        gui.pane.insertIcon(new ImageIcon("dice" + number + ".png"));
        switch (turnPlayer) {
            case 1:
                intX = 0;
                intY = 0;
                player1 += number;
                player1 = checkCell(player1);
                player1 = winCheck(player1);
                cell = player1;
                turnPlayerName = "Первый";
                temp = cellCoord(conusPointPlayer1, player1);
                conusPointPlayer1.move(temp.x, temp.y);
                gui.conus1P.setCoord(conusPointPlayer1);
                checkColor();
                if (number != 6) {
                    turnPlayer = 2;
                } else {
                    gui.pane.appendtoPane(gui.pane, "Шестёрка! Право повторного броска!" + "\n", pl);
                }
                break;
            case 2:
                intX = 5;
                intY = 5;
                player2 += number;
                player2 = checkCell(player2);
                player2 = winCheck(player2);
                cell = player2;
                turnPlayerName = "Второй";
                temp = cellCoord(conusPointPlayer2, player2);
                conusPointPlayer2.move(temp.x, temp.y);
                gui.conus2P.setCoord(conusPointPlayer2);
                checkColor();
                if (number != 6) {
                    turnPlayer = 1;
                } else {
                    gui.pane.appendtoPane(gui.pane, "Шестёрка! Право повторного броска!" + "\n", pl);
                }
                break;
        }
        gui.pane.appendtoPane(gui.pane, turnPlayerName + " игрок ходит на " + cell + " клетку" + "\n", pl);
        if (win == true) {
            gui.pane.appendtoPane(gui.pane, turnPlayerName + " игрок победил!", pl);
            gui.button.setEnabled(false);
        }
        gui.image = null;
        gui.panel.drawConus(gui.conus1P, gui.conus2P);

    }

    private int winCheck(int player) {
        if (player == 100) {
            win = true;
            return player;
        }
        if (!gui.with100Button.isSelected() && player > 100) {
            win = true;
            player = 100;
            return player;
        } else if (!gui.without100Button.isSelected() && player > 100) {
            player = 100 - (player - 100);
        }
        return player;
    }

    public void printMSG(String msg) {
        gui.pane.appendtoPane(gui.pane, msg + "\n", Color.BLUE);
    }

    public int checkCell(int player) {
        switch (player) {
            case 1:
                player = 38;
                printMSG("*****Лестница!*****");
                break;
            case 4:
                player = 14;
                printMSG("*****Лестница!*****");
                break;
            case 9:
                player = 31;
                printMSG("*****Лестница!*****");
                break;
            case 21:
                player = 42;
                printMSG("*****Лестница!*****");
                break;
            case 28:
                player = 84;
                printMSG("*****Могучая Лестница!*****");
                break;
            case 36:
                player = 44;
                printMSG("*****Лестница!*****");
                break;
            case 51:
                player = 67;
                printMSG("*****Лестница!*****");
                break;
            case 71:
                player = 91;
                printMSG("*****Лестница!*****");
                break;
            case 80:
                player = 100;
                printMSG("*****Лестница к победе!*****");
                break;
            case 16:
                player = 6;
                printMSG("*****Змейка!*****");
                break;
            case 47:
                player = 26;
                printMSG("*****Змейка!*****");
                break;
            case 49:
                player = 30;
                printMSG("*****Змейка!*****");
                break;
            case 56:
                player = 53;
                printMSG("*****Змейка!*****");
                break;
            case 62:
                player = 19;
                printMSG("*****Страшная Змейка!*****");
                break;
            case 63:
                player = 60;
                printMSG("*****Слабая Змейка!*****");
                break;
            case 87:
                player = 24;
                printMSG("*****Страшная Змейка!*****");
                break;
            case 93:
                player = 73;
                printMSG("*****Змейка!*****");
                break;
            case 95:
                player = 75;
                printMSG("*****Змейка!*****");
                break;
            case 98:
                player = 78;
                printMSG("*****Змейка!*****");
                break;
        }
        return player;
    }

    public Point cellCoord(Point xyIn, int numPole) {
        Point temp = xyIn;

        if (numPole > 0 && numPole < 11) {
            temp.move(50 * numPole + intX, 500 + intY);
        } else if (numPole > 10 && numPole < 21) {
            temp.move(550 - (numPole - 10) * 50 + intX, 450 + intY);
        } else if (numPole > 20 && numPole < 31) {
            temp.move(50 * (numPole - 20) + intX, 400 + intY);
        } else if (numPole > 30 && numPole < 41) {
            temp.move(550 - (numPole - 30) * 50 + intX, 350 + intY);
        } else if (numPole > 40 && numPole < 51) {
            temp.move(50 * (numPole - 40) + intX, 300 + intY);
        } else if (numPole > 50 && numPole < 61) {
            temp.move(550 - (numPole - 50) * 50 + intX, 250 + intY);
        } else if (numPole > 60 && numPole < 71) {
            temp.move(50 * (numPole - 60) + intX, 200 + intY);
        } else if (numPole > 70 && numPole < 81) {
            temp.move(550 - (numPole - 70) * 50 + intX, 150 + intY);
        } else if (numPole > 80 && numPole < 91) {
            temp.move(50 * (numPole - 80) + intX, 100 + intY);
        } else if (numPole > 90 && numPole < 101) {
            temp.move(550 - (numPole - 90) * 50 + intX, 50 + intY);
        }
        return (temp);
    }

}
