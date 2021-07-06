import com.dropbox.core.v2.DbxClientV2;

import java.awt.image.BufferedImage;
import java.io.InputStream;

public class Uploader extends Thread {

    private BufferedImage image;
    private DbxClientV2 client;

    public Uploader(DbxClientV2 client, BufferedImage image) {
        this.client = client;
        this.image = image;
    }

    @Override
    public void run() {
    // TODO:
    // 1. Convert "image" to InputStream
        // using ByteArrayInputStream and ByteArrayOutputStream
    // 2. file name like 20210608_172735.png
        // Upload "test.txt" to Dropbox
        try {
            InputStream in = null;

            client.files().uploadBuilder("/FILENAME.png").uploadAndFinish(in);
        } catch (Exception ex) {
            ex.printStackTrace();
        }


//        for(int i = 0; i < 100; i++) {
//            System.out.println(i);
//            try {
//                sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
}