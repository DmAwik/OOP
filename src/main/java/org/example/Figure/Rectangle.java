package org.example.Figure;

import org.example.Figures;
import javafx.scene.paint.Color;

public class Rectangle extends Figures {

    public  Rectangle(int PenSize,Color StrokeColor,Color BrushColor) {
        this.PenSize = PenSize;
        this.StrokeColor = StrokeColor;
        this.BrushColor = BrushColor;
    }
}