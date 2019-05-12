package com.car.common.utils.picture;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

public class PictureUtil {

    public static ByteArrayOutputStream createImage(BufferedImage image) {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ImageIO.write(image, "jpg", bos);
            bos.close();
            return bos;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
