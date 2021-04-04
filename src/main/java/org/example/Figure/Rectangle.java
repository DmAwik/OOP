package org.example.Figure;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import org.example.Figures;
import javafx.scene.paint.Color;

public class Rectangle extends Figures {

    private double width;
    private double height;
    private Point2D topLeftCorner;

    public Rectangle(GraphicsContext gc,double height,double width,Point2D topLeftCorner){
        super(gc);
        polyFigure=false;
        this.height=height;
        this.width=width;
        this.topLeftCorner=topLeftCorner;
    }

    @Override
    public void paint(GraphicsContext gc){
        figureStyle(gc);

        gc.strokeRect(width > 0 ? topLeftCorner.getX() : topLeftCorner.getX() + width,
                height > 0 ? topLeftCorner.getY() : topLeftCorner.getY() + height,
                Math.abs(width), Math.abs(height));

        gc.fillRect(width > 0 ? topLeftCorner.getX() : topLeftCorner.getX() + width,
                height > 0 ? topLeftCorner.getY() : topLeftCorner.getY() + height,
                Math.abs(width), Math.abs(height));

    }
    @Override
    public void saveLastPoint(Point2D newPoint){
        height = newPoint.getY() - topLeftCorner.getY();
        width = newPoint.getX() - topLeftCorner.getX();
    }
}
