package org.example.Factory;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import org.example.Figure.Rectangle;

import java.lang.management.GarbageCollectorMXBean;

public class RectangleFactory implements FiguresFactory {
    @Override
    public Rectangle newFigure(GraphicsContext gc, Point2D startPoint){
        return new Rectangle(gc,0,0,startPoint);
    }
}
