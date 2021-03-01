package org.example;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import org.w3c.dom.css.Rect;

public class Main extends Application {
    public static void main(String[] args) {
    Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Circle circle = new Circle(100,80,50);
        circle.setFill(Color.YELLOW);

        Polygon polygon = new Polygon();
        polygon.getPoints().addAll(new Double[]{
                0.0, 0.0,
                20.0, 10.0,
                10.0, 20.0 });

        Rectangle rectangle = new Rectangle(200,200,300,300);
        rectangle.setFill(Color.GREEN);

        Line line =new Line(500,600,600,700);
        line.setStroke(Color.RED);
        Group PaintBox = new Group();
        Scene scene = new Scene(PaintBox,800,800);

        PaintBox.getChildren().add(circle);
        PaintBox.getChildren().add(rectangle);
        PaintBox.getChildren().add(polygon);
        PaintBox.getChildren().add(line);




        primaryStage.setTitle("FirstLab");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
