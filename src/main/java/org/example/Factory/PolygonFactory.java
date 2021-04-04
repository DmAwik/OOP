package org.example.Factory;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import org.example.Figure.Polygon;

public class PolygonFactory implements FiguresFactory {
    @Override
    public org.example.Figure.Polygon newFigure(GraphicsContext gc, Point2D startPoint){
        return new Polygon(gc,startPoint,startPoint);
    }
}
