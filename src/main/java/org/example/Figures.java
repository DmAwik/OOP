package org.example;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;

public abstract class Figures {

    private double penSize;
    private Paint brushColor;
    private Paint strokeColor;
    public boolean polyFigure;


    public Figures(GraphicsContext gc){
        strokeColor = gc.getStroke();
        brushColor = gc.getFill();
        penSize= gc.getLineWidth();
    }

    public abstract void paint(GraphicsContext gc);

    public boolean isPolyFigure() {
        return polyFigure;
    }

    public abstract void saveLastPoint(Point2D newPoint);

    public void addPoint(Point2D newPoint){};

    public void deleteLastPoint(){};

    public void figureStyle (GraphicsContext gc){
        gc.setStroke(strokeColor);
        gc.setFill(brushColor);
        gc.setLineWidth(penSize);
    }
}
