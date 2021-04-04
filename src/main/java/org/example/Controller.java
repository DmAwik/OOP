package org.example;

import java.net.URL;
import java.util.*;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import org.example.Factory.*;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Canvas canvasDraw;

    @FXML
    private Canvas canvasPreview;

    @FXML
    private Button btnPolygone;

    @FXML
    private Button btnRectangle;

    @FXML
    private Button btnCircle;

    @FXML
    private Button btnLine;

    @FXML
    private Button btnPolyLine;

    @FXML
    private TextField PenSize;

    @FXML
    private Button btnNew;

    @FXML
    private ColorPicker strokeColor;

    @FXML
    private ColorPicker brushColor;

    private GraphicsContext gcDraw,gcPreview;
    private final List<FiguresFactory> figuresFactoryList = Arrays.asList(new LineFactory(), new PolylineFactory(), new PolygonFactory(), new RectangleFactory(), new CircleFactory() );
    private final List<Figures> figuresList = new ArrayList<>();
    private int figureIndex;
    private Figures currentFigure;
    private boolean isDraw = false;

    @FXML
    public void onButtonClicked(MouseEvent mouseEvent){
        btnLine.setOnMouseClicked(event -> {
            figureIndex = 0;
        });
        btnPolyLine.setOnMouseClicked(event -> {
            figureIndex = 1;
        });
        btnPolygone.setOnMouseClicked(event -> {
            figureIndex = 2;
        });
        btnRectangle.setOnMouseClicked(event -> {
            figureIndex = 3;
        });
        btnCircle.setOnMouseClicked(event -> {
            figureIndex = 4;
        });


    }

    @FXML
    public void initialize() {
        PenSize.setText("1");

        gcDraw = canvasDraw.getGraphicsContext2D();
        gcPreview = canvasPreview.getGraphicsContext2D();
        gcDraw.setFill(brushColor.getValue());
        gcDraw.setStroke(strokeColor.getValue());
        gcDraw.setLineWidth(Double.parseDouble(PenSize.getText()));
        canvasPreview.setVisible(false);

    }

    public void brushColorChange(ActionEvent actionEvent) {
        gcDraw.setFill(brushColor.getValue());
    }

    public void strokeColorChange(ActionEvent actionEvent) {
        gcDraw.setStroke(strokeColor.getValue());
    }

    public void penSizeChange(ActionEvent actionEvent) {
        gcDraw.setLineWidth(Double.parseDouble(PenSize.getText()));
    }
    public void onCanvasClicked(MouseEvent mouseEvent) {

            if (!isDraw) {
                FiguresFactory figuresFactory = figuresFactoryList.get(figureIndex);
                currentFigure = figuresFactory.newFigure(canvasDraw.getGraphicsContext2D(), new Point2D(mouseEvent.getX(), mouseEvent.getY()));
                isDraw = true;

            } else {
                if (currentFigure.isPolyFigure()) {
                    currentFigure.addPoint(new Point2D(mouseEvent.getX(), mouseEvent.getY()));
                    figuresList.add(currentFigure);

                } else {
                         currentFigure.paint(gcDraw);
                         canvasPreview.setVisible(false);
                         figuresList.add(currentFigure);
                    isDraw = false;
                }
            }
    }

    public void onCanvasMouseMoved(MouseEvent mouseEvent) {
        if (isDraw) {
            canvasPreview.setVisible(true);
            gcPreview.clearRect(0, 0, canvasPreview.getWidth(), canvasPreview.getHeight());
            currentFigure.saveLastPoint(new Point2D(mouseEvent.getX(), mouseEvent.getY()));
            currentFigure.paint(gcPreview);
        }
    }

    public void onKeyPressed(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ESCAPE && currentFigure.isPolyFigure()){
            currentFigure.deleteLastPoint();
            currentFigure.paint(gcDraw);
            canvasPreview.setVisible(false);
            isDraw = false;
        }
    }
}
