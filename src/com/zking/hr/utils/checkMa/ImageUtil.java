package com.zking.hr.utils.checkMa;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * ����֤�����ɹ���
 * ImageUtil, ����������֤��
 * createImage��������һ��Map����,Map ��key������������֤����ַ���,
 * Map��value����������BufferImage���͵���֤��;
 * getInputStream������ BufferImageת��InputStream����;
 * @author huangpeng
 */
public class ImageUtil {
    private static final char[] chars = {'0','1','2','3','4','5','6','7','8','9',
        'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q',
        'r','s','t','u','v','w','x','y','z','A','B','C','D','E','F','G','H',
        'I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    private static final int SIZE = 4;            //�ַ���
    private static final int LINES = 12;        //����������
    private static final int WIDTH = 130;        //���ɵ���֤��ͼƬ�Ŀ��
    private static final int HEIGHT = 60;        //���ɵ���֤��ͼƬ�ĳ���
    private static final int FONT_SIZE = 40;    //�����С

    public static Map<String, BufferedImage> createImage(){
        //�û������ַ���
        StringBuffer sb = new StringBuffer();
        //BufferImage���͵���֤��
        BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        //��û��� 
        Graphics g = image.getGraphics();
        g.setColor(Color.LIGHT_GRAY);    //���ñ���ɫ
        g.fillRect(0, 0, WIDTH, HEIGHT);//������ɫ��䵽ͼƬ��
        Random ran = new Random();    //���һ��Random����
        
        //���ַ�
        for(int i=1; i<=SIZE; i++){
            int r = ran.nextInt(chars.length);    //�õ�һ��������±�, chars �Ǳ����������ַ���char�ַ�
            g.setColor(getRandomColor());        //�õ�һ���������ɫ
            g.setFont(new Font(null, Font.BOLD+Font.ITALIC, FONT_SIZE));    //���������С
            g.drawString(chars[r]+"", (i-1)*WIDTH/SIZE, (int)(HEIGHT*0.7));    //���ַ�
            sb.append(chars[r]);
        }
        
        //��������
        for(int i=1; i<=LINES; i++){
            g.setColor(getRandomColor());    //ͬ����������Ҳ�����������ɫ
            g.drawLine(ran.nextInt(WIDTH), ran.nextInt(HEIGHT), 
                    ran.nextInt(WIDTH), ran.nextInt(HEIGHT));//������ø����ߵķ���
        }
        
        //��ͼƬ�е��ַ�������ΪMap�����key��BufferedImage����Ϊvalue
        Map<String, BufferedImage> map = new HashMap<String, BufferedImage>();    
        map.put(sb.toString(), image);
        return map;
    }

    /**
     * ���һ���������ɫ ���� Color����
     * @return
     */
    private static Color getRandomColor() {
        Random ran = new Random();
        Color color = new Color(ran.nextInt(256), ran.nextInt(256), ran.nextInt(256)); 
        return color;
    }

    /**
     * �� BufferImageת��InputStream����
     * @param image
     * @return
     * @throws IOException
     */
    public static InputStream getInputStream(BufferedImage image) throws IOException{
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(bos);
        encoder.encode(image);
        byte[] imageBts = bos.toByteArray();
        InputStream in = new ByteArrayInputStream(imageBts);
        return in;
    }
}