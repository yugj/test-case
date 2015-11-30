package util;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;
 
/**
 * ͼƬˮӡ
 * ʵ��ͼƬˮӡ������λ�鿴
 */
public class ImageUtil {
    /**
     * @param args
     */
    public static void main(String[] args) {
        String srcImgPath = "f:/temp/1.png";
        String targerPath = "f:/temp/4.png";
        // ��ͼƬ���ˮӡ,ˮӡ��ת-45
        ImageUtil.waterMarkByText("javaˮӡͼƬ", srcImgPath, targerPath, 45, 100, 100, 0.5f);
    }
 
 
    /**
     * ��ͼƬ���ˮӡ��������ˮӡͼƬ��ת�Ƕ�
     * 
     * @param logoText
     *            ˮӡ����
     * @param srcImgPath
     *            ԴͼƬ·��
     * @param targerPath
     *            Ŀ��ͼƬ·��
     * @param degree
     *            ˮӡͼƬ��ת�Ƕ�
     * @param width
     *            ���(�������)
     * @param height
     *            �߶�(�붥���)
     * @param clarity
     *            ͸����(С��1����)Խ�ӽ�0Խ͸��
     */
    public static void waterMarkByText(String logoText, String srcImgPath, String targerPath, Integer degree, Integer width,
            Integer height, Float clarity) {
        // ��ͼƬ��·��
        InputStream is = null;
        OutputStream os = null;
        try {
            Image srcImg = ImageIO.read(new File(srcImgPath));
            BufferedImage buffImg = new BufferedImage(srcImg.getWidth(null), srcImg.getHeight(null), BufferedImage.TYPE_INT_RGB);
            // �õ����ʶ���
            Graphics2D g = buffImg.createGraphics();
            // ���ö��߶εľ��״��Ե����
            g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g.drawImage(srcImg.getScaledInstance(srcImg.getWidth(null), srcImg.getHeight(null), Image.SCALE_SMOOTH), 0, 0, null);
            g.rotate(Math.toRadians(degree), (double) buffImg.getWidth() / 2, (double) buffImg.getHeight() / 2);
            g.setColor(Color.red);
            g.setFont(new Font("����", Font.BOLD, 30));
            
            float alpha = clarity;
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));
            // ��һ����->���õ����ݣ�������������->������ͼƬ�ϵ�����λ��(x,y) .
            g.drawString(logoText, width, height);
            g.dispose();
            os = new FileOutputStream(targerPath);
            // ����ͼƬ
            ImageIO.write(buffImg, "JPG", os);
            System.out.println("���ˮӡ�������!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != is) { 
                	is.close();
                	is = null;
                }
                if(null != os) {
                	os.close();
                	os = null;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
 
    /**
     * ͼƬ����(ͼƬ�ȱ�������Ϊָ����С���հײ����԰�ɫ���)
     * 
     * @param srcPath
     *            ԴͼƬ·��
     * @param destPath
     *            ���ź�ͼƬ·��
     */
    public static void zoomImage(String srcPath, String destPath, int destHeight, int destWidth) {
        try {
            BufferedImage srcBufferedImage = ImageIO.read(new File(srcPath));
            int imgWidth = destWidth;
            int imgHeight = destHeight;
            int srcWidth = srcBufferedImage.getWidth();
            int srcHeight = srcBufferedImage.getHeight();
            if (srcHeight >= srcWidth) {
                imgWidth = (int) Math.round(((destHeight * 1.0 / srcHeight) * srcWidth));
            } else {
                imgHeight = (int) Math.round(((destWidth * 1.0 / srcWidth) * srcHeight));
            }
            BufferedImage destBufferedImage = new BufferedImage(destWidth, destHeight, BufferedImage.TYPE_INT_RGB);
            Graphics2D graphics2D = destBufferedImage.createGraphics();
            graphics2D.setBackground(Color.WHITE);
            graphics2D.clearRect(0, 0, destWidth, destHeight);
            graphics2D.drawImage(srcBufferedImage.getScaledInstance(imgWidth, imgHeight, Image.SCALE_SMOOTH), (destWidth / 2)
                    - (imgWidth / 2), (destHeight / 2) - (imgHeight / 2), null);
            graphics2D.dispose();
            ImageIO.write(destBufferedImage, "JPEG", new File(destPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
