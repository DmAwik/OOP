package org.example.Factory;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import org.example.Figure.Circle;

public class CircleFactory implements FiguresFactory {
    @Override
    public Circle newFigure(GraphicsContext gc, Point2D startPoint){
        return new Circle(gc,0,0,startPoint);
    }
}
