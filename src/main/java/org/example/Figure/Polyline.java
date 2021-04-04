package org.example.Figure;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import org.example.Figures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Polyline extends Figures {

    private List<Point2D> listOfPoints;

    public Polyline(GraphicsContext gc, Point2D... listOfPoints){
        super(gc);
        polyFigure = true;
        this.listOfPoints =new ArrayList<>();
        this.listOfPoints.addAll(Arrays.asList(listOfPoints));
    }
    @Override
    public void paint(GraphicsContext gc){
        figureStyle(gc);
        for (int count = 0; count < listOfPoints.size() - 1; count++) {
            Point2D startPoint = listOfPoints.get(count);
            Point2D secondPoint = listOfPoints.get(count + 1);
            gc.strokeLine(startPoint.getX(), startPoint.getY(), secondPoint.getX(), secondPoint.getY());
        }
    }
    @Override
    public void saveLastPoint(Point2D newPoint){
        listOfPoints.set(listOfPoints.size()-1,newPoint);
    }
    @Override
    public void addPoint(Point2D newPoint){
        listOfPoints.add(newPoint);
    }
    @Override
    public void deleteLastPoint(){
        listOfPoints.remove(listOfPoints.size()-1);
    }
}