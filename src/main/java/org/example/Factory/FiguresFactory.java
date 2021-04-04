package org.example.Factory;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import org.example.Figures;

public interface FiguresFactory {
     Figures newFigure(GraphicsContext gc, Point2D startPoint);
}
