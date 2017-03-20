package sample;

import javafx.event.ActionEvent;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

import static java.lang.Integer.parseInt;

public class Controller implements Initializable{

    Point p1 = new Point(10, 10);
    Point p2 = new Point(150, 10);
    Point p3 = new Point(10, 200);
    Triangle t1 = new Triangle(p1, p2, p3);

     Point q1;
     Point q2;
     Point q3;



    @FXML private Canvas canvas1;
    private GraphicsContext gc1;
    Triangle t2;

    @FXML private TextField tf_p1x, tf_p1y, tf_p2x, tf_p2y, tf_p3x, tf_p3y, tf_deg;

    private void getPointInput(){
        double xOffset = canvas1.getWidth()/2;
        double yOffset = canvas1.getHeight()/2;

        q1 = new Point(Double.parseDouble(tf_p1x.getText()) + xOffset, Double.parseDouble(tf_p1y.getText()) + yOffset);
        q2 = new Point(Double.parseDouble(tf_p2x.getText()) + xOffset, Double.parseDouble(tf_p2y.getText()) + yOffset);
        q3 = new Point(Double.parseDouble(tf_p3x.getText()) + xOffset, Double.parseDouble(tf_p3y.getText()) + yOffset);
    }

    private void drawCoordinateSystem(){
        double canvas_half_height = canvas1.getHeight() / 2;
        double canvas_half_width = canvas1.getWidth() / 2;
        gc1 = canvas1.getGraphicsContext2D();
        gc1.setLineWidth(2);
        gc1.setStroke(Color.BLACK);
        gc1.strokeLine(5, canvas_half_height, canvas1.getWidth() - 5, canvas_half_height); // x-axis
        gc1.strokeLine(canvas_half_width, 5, canvas_half_width, canvas1.getHeight() - 5); // y-axis
    }

    @FXML private void drawTriangle(ActionEvent event){
        getPointInput();
        t2 = new Triangle(q1, q2, q3);
        gc1.clearRect(0, 0, canvas1.getWidth(), canvas1.getHeight());
        drawCoordinateSystem();
        t2.draw(gc1);
    }

    @FXML private void rotate(ActionEvent event){
        getPointInput();
        double deg = Double.parseDouble(tf_deg.getText());
        t2.rotate(deg, canvas1.getWidth()/2, canvas1.getHeight()/2);
        gc1.clearRect(0, 0, canvas1.getWidth(), canvas1.getHeight());
        drawCoordinateSystem();
        t2.draw(gc1);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources){
        drawCoordinateSystem();
    }

}
