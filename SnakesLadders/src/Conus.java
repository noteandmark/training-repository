import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Conus {
    private String player;
    private Point coord;;
    private BufferedImage image;

    public Conus(String player, Point coord, BufferedImage image) {
        this.player = player;
        this.coord = coord;
        this.image = image;
    }

    public Conus(){}

    public Point getCoord() {
        return coord;
    }

    public void setCoord(Point coord) {
        this.coord = coord;
    }

    public BufferedImage getImage() {
        return image;
    }
}
