package org.example.Figure;

import javafx.scene.paint.Color;
import org.example.Figures;

public class Octagon extends Figures {
    @Override
    public void Paint() {

    }
    public Octagon(int PenSize, Color StrokeColor, Color BrushColor) {
        this.PenSize = PenSize;
        this.StrokeColor = StrokeColor;
        this.BrushColor = BrushColor;

    }
}