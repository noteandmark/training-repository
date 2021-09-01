import javax.imageio.ImageIO;
import java.io.File;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class MyGUI extends JFrame {
    private BufferedImage conus1;
    private BufferedImage conus2;
    public BufferedImage image;
    private int startconus1X = 20;
    private int startconus1Y = 510;
    private int startconus2X = 25;
    private int startconus2Y = 515;
    //50,515 - координаты 1ой ячейки
    private Point conusPointPlayer1 = new Point(startconus1X,startconus1Y);
    private Point conusPointPlayer2 = new Point(startconus2X,startconus2Y);
    private Point currentPoint = new Point(-50, -50);
    public Conus conus1P;
    public Conus conus2P;

    Board panel = new Board();
    Pane pane = new Pane();
    JScrollPane scrollerP = new JScrollPane(pane);
    JButton button = new JButton("Бросить кубик");
    JLabel pic = new JLabel();
    ButtonGroup group = new ButtonGroup();
    JRadioButton withHuman = new JRadioButton("С человеком");
    JRadioButton withPC = new JRadioButton("С компьютером");
    JRadioButton with100Button = new JRadioButton("Игра строго до 100");
    JRadioButton without100Button = new JRadioButton("Игра до/больше 100");
    ButtonGroup group1 = new ButtonGroup();
    ButtonGroup group2 = new ButtonGroup();
    JRadioButton withVCube = new JRadioButton("С вирт. кубиком");
    JRadioButton withRCube = new JRadioButton("С реальным кубиком");

    public MyGUI() {

        JPanel panelLog = new JPanel();
        JLabel auhtor = new JLabel("author: Андрей Марков");
        JLabel version = new JLabel("year: 2021. version: 0.90");
        button.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        pane.setBorder(new LineBorder(Color.ORANGE, 2));
        scrollerP.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollerP.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        panelLog.setLayout(new BoxLayout(panelLog, BoxLayout.Y_AXIS));
        scrollerP.setPreferredSize(new Dimension(150,100));
        panelLog.add(button);
        panelLog.add(pane);
        scrollerP.setViewportView(pane);
        panelLog.add(scrollerP);
        with100Button.setSelected(true);
        withHuman.setSelected(true);
        withVCube.setSelected(true);
        group2.add(withHuman);
        group2.add(withPC);
        panelLog.add(withHuman);
        panelLog.add(withPC);
        group.add(with100Button);
        group.add(without100Button);
        panelLog.add(with100Button);
        panelLog.add(without100Button);
        group1.add(withVCube);
        group1.add(withRCube);
        panelLog.add(withVCube);
        panelLog.add(withRCube);
        panelLog.add(auhtor);
        panelLog.add(version);
        withPC.setEnabled(false);
        conus1P = new Conus("player1", conusPointPlayer1,conus1);
        conus2P = new Conus("player2", conusPointPlayer2,conus2);
        panel.drawConus(conus1P, conus2P);

        JFrame frame = new JFrame("Змейки и Лестницы");
        frame.setPreferredSize(new Dimension(840, 630));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(BorderLayout.EAST, panelLog);
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

        SnakeEngine game = new SnakeEngine(this);
        button.addActionListener(game);
    }

    public class Pane extends JTextPane {
        public Pane() {

        }
        public void appendtoPane(JTextPane pane, String msg, Color c) {
            StyleContext sc = StyleContext.getDefaultStyleContext();
            AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, c);
            aset = sc.addAttribute(aset, StyleConstants.FontFamily, "Lucida Console");
            aset = sc.addAttribute(aset, StyleConstants.Alignment, StyleConstants.ALIGN_JUSTIFIED);
            int len = pane.getDocument().getLength();
            pane.setCaretPosition(len);
            pane.setCharacterAttributes(aset, false);
            pane.replaceSelection(msg);
        }
    }


    public class Board extends JPanel {

        public Board() {

            try {
                image = ImageIO.read(new File("snake.jpg"));
                conus1 = ImageIO.read(new File("conus1.png"));
                conus2 = ImageIO.read(new File("conus2.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void drawConus(Conus conus1P, Conus conus2P) {
            if (image == null) {
                try {
                    image = ImageIO.read(new File("snake.jpg"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            Graphics g = image.getGraphics();
            image.getGraphics().drawImage(conus1P.getImage(), conus1P.getCoord().x, conus1P.getCoord().y, null);
            image.getGraphics().drawImage(conus2P.getImage(), conus2P.getCoord().x, conus2P.getCoord().y, null);
            panel.revalidate();
            panel.repaint();
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image, 0, 0, this);
        }

    }

}
