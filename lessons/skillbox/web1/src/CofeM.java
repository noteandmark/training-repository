import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class CofeM {
    public static void main(String[] args) throws DbxException, AWTException, IOException, InterruptedException {

//        Scanner myInput = new Scanner(System.in);
//        int moneyAmount = myInput.nextInt();
//        System.out.println("Вы внесли: " + moneyAmount + " руб.");

//        MyThread thread = new MyThread();
//        thread.start();

        String ACCESS_TOKEN = "XdadZD0lckEAAAAAAAAAAaQ2yRdBpOlyPkmEpBo9W6izESFgIt8hkdxrStgXTMn5";

        // Create Dropbox client
        DbxRequestConfig config = new DbxRequestConfig("dropbox/java-tutorial", "en_US");
        DbxClientV2 client = new DbxClientV2(config, ACCESS_TOKEN);

        for (;;) {
            BufferedImage image = null;
            Uploader uploader = new Uploader(client, image);
            uploader.run();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Upload "test.txt" to Dropbox
//        try {
//            InputStream in =
//                    new FileInputStream("C://Users/prism/Desktop/java.jpg");
//
//            client.files().uploadBuilder("/picture.jpg").uploadAndFinish(in);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }

        /*

        int[] drinkPrices = {180, 170, 120, 90};
        String[] drinkNames = {"капучино","латте","американо", "молоко"};

        CoffeMachine machine = new CoffeMachine(drinkPrices, drinkNames);
        machine.checkPrice(moneyAmount);

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd_HHmmss");
        Date now = new Date();
        System.out.println(formatter.format(now));

        // capture screenshot to BufferedImage
            BufferedImage screenShot = null;
            Robot robo = new Robot();
            screenShot = robo.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
            ImageIO.write(screenShot, "JPG", new File("screenShot.jpg"));
//            Rectangle screen = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
//            BufferedImage image = robo.createScreenCapture(screen);
//          ImageIO.write(image, "png", new File(formatter.format(now) + "_screenshot.png"));
            System.out.println(screenShot.getWidth() + "x" + screenShot.getHeight());
    }



        if (!canBuy) {
            System.out.println("У вас недостаточно средств");
        }
        */
    }
}
