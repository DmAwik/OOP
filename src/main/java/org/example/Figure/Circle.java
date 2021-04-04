package org.example.Figure;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import org.example.Figures;

public class Circle extends Figures {

    private double width;
    private double height;
    private Point2D topLeftCorner;

    public  Circle(GraphicsContext gc, double height,double width,Point2D topLeftCorner){
        super(gc);
        polyFigure=false;
        this.height=height;
        this.width=width;
        this.topLeftCorner = topLeftCorner;
        polyFigure =false;
    }
    @Override
    public void paint(GraphicsContext gc){
        figureStyle(gc);

        gc.strokeOval(width > 0 ? topLeftCorner.getX() : topLeftCorner.getX() + width,
                height > 0 ? topLeftCorner.getY() : topLeftCorner.getY() + height,
                Math.abs(width), Math.abs(height));

        gc.fillOval(width > 0 ? topLeftCorner.getX() : topLeftCorner.getX() + width,
                height > 0 ? topLeftCorner.getY() : topLeftCorner.getY() + height,
                Math.abs(width), Math.abs(height));

    }
    @Override
    public void saveLastPoint(Point2D newPoint){
        width = newPoint.getX() - topLeftCorner.getX();
        height =newPoint.getY()-topLeftCorner.getY();

    }
}