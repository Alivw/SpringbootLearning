package com.awei.security.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

/**
 * @program: SpringbootTest
 * @author: Awei
 * @create: 2021-03-03 16:01
 **/
@Controller
@RequestMapping("/captcha")
public class CaptchaController {

    //定义图片宽度
    private int width = 120;
    //图片高度
    private int height = 30;
    //图片内容在图片的起始位置
    private int drawY = 18;

    //多少位验证码
    private int charCount = 6;

    //文字间隔
    private int space = 15;

    private String chars[] = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","1","2","3","4","5","6","7","8","9","0"};

    @RequestMapping("/code")
    public void makeCaptcha(HttpServletResponse response, HttpServletRequest request) throws IOException {

        //背景透明的图片

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        //获取画笔
        Graphics g = image.getGraphics();
        //白色画笔

        g.setColor(Color.white);
        //全部涂白
        g.fillRect(0, 0, width, height);
        //画内容
        g.setColor(Color.BLACK);
        Font f = new Font("宋体", Font.BOLD, 16);
        g.setFont(f);
        int ran = 0;
        StringBuffer buffer = new StringBuffer("");
        for (int i = 0; i < charCount; i++) {
            ran = new Random().nextInt(chars.length);
            g.setColor(makeColor());
            buffer.append(chars[ran]);
            g.drawString(chars[ran], (i + 1) * space, drawY);
        }
        request.getSession().setAttribute("code", buffer.toString());



        //画干扰线
        for (int i = 0; i < 5; i++) {
            g.setColor(makeColor());
            int dot[] = makeLineOut();
            g.drawLine(dot[0], dot[1], dot[2], dot[3]);
        }

        //设置没有缓存
        response.setHeader("Prama", "no-cache");
        response.setHeader("Cache-Controll", "no-cache");
        response.setDateHeader("Expires", 0);

        response.setContentType("img/png");
        OutputStream out = response.getOutputStream();

        ImageIO.write(image, "png", out);

        out.flush();
        out.close();

    }

    private Color makeColor() {
        Random ran = new Random();
        int r = new Random().nextInt(255);
        int g = new Random().nextInt(255);
        int b= new Random().nextInt(255);
        return new Color(r, g, b);
    }

    private int[] makeLineOut() {
        Random ran = new Random();
        int x1 = ran.nextInt(width / 2);
        int y1 = ran.nextInt(height);
        int x2 = ran.nextInt(width);
        int y2 = ran.nextInt(height);
        return new int[]{x1, y1, x2, y2};
    }
}
