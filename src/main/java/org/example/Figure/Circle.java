package org.example.Figure;

import javafx.scene.paint.Color;
import org.example.Figures;

public class Circle extends Figures {
    @Override
    public void Paint() {

    }
    public Circle(int PenSize, Color StrokeColor, Color BrushColor) {
        this.PenSize = PenSize;
        this.StrokeColor = StrokeColor;
        this.BrushColor = BrushColor;

    }
}