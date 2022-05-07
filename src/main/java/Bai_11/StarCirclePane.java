/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
        
package Bai_11;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import javax.swing.JPanel;

/**
 *
 * @author ADMIN
 */
public class StarCirclePane extends JPanel {
    public StarCirclePane() {
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400, 300);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        int midX = getWidth() / 2;
        int midY = getHeight() / 2;
        int size = 50;
        for (int index = 0; index < 20; index++) {
            g2d.setColor(new Color((int)(Math.random() * 0x1000000)));
            double angle = (360d / 20d) * index;
            Point2D poc = getPointOnCircle(angle, 80 - 25);
            Star2D star = new Star2D(midX + poc.getX() - size / 3, midY + poc.getY() - size / 3, size / 3, size, 5);
            AffineTransform origX = g2d.getTransform();
            AffineTransform newX = (AffineTransform) origX.clone();
            newX.rotate(Math.toRadians(angle), midX + poc.getX() - 2, midY + poc.getY() - 2);
            g2d.setTransform(newX);
            g2d.fill(star);
            g2d.setTransform(origX);
        }
        g2d.dispose();
    }

    protected Point2D getPointOnCircle(double degress, double radius) {
        double rads = Math.toRadians(degress - 90); // 0 becomes the top

        return new Point2D.Double(Math.cos(rads) * radius, Math.sin(rads) * radius);
    }
}
