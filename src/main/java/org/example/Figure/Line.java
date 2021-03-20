package org.example.Figure;
import javafx.scene.paint.Color;
import org.example.Figures;
public class Line extends Figures {
    @Override
    public void Paint() {

    }
    public Line(int PenSize,Color BrushColor) {
        this.PenSize = PenSize;
        this.BrushColor = BrushColor;
    }
}