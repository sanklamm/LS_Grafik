package sample;

import javafx.scene.canvas.GraphicsContext;

/**
 * Created by s on 02/03/17.
 */
public class Triangle {
        Point p1;
        Point p2;
        Point p3;

        public Triangle(Point p1, Point p2, Point p3){
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    public Point getP(int i){
        switch (i){
            case 1:
                return this.p1;
            case 2:
                return this.p2;
            case 3:
                return this.p3;
            default:
                return null;
        }
    }

    // rotate points around (0, 0) --> (upper left corner of Canvas
    public void rotate(double deg){
        Matrix rot_mat = Transform.create_rot_mat(deg);

        // rotate p1
        double[][] vecData = new double[][]{{this.p1.x}, {this.p1.y}, {this.p1.z}};
        Matrix vec1 = new Matrix(vecData);
        Matrix vec1_rotated = rot_mat.times(vec1);
        this.p1.x = vec1_rotated.getData()[0][0];
        this.p1.y = vec1_rotated.getData()[1][0];
        this.p1.z = vec1_rotated.getData()[2][0];

        vecData = new double[][] {{this.p2.x}, {this.p2.y}, {this.p2.z}};
        Matrix vec2 = new Matrix(vecData);
        Matrix vec2_rotated = rot_mat.times(vec2);
        this.p2.x = vec2_rotated.getData()[0][0];
        this.p2.y = vec2_rotated.getData()[1][0];
        this.p2.z = vec2_rotated.getData()[2][0];

        vecData = new double[][] {{this.p3.x}, {this.p3.y}, {this.p3.z}};
        Matrix vec3 = new Matrix(vecData);
        Matrix vec3_rotated = rot_mat.times(vec3);
        vec3_rotated.show();
        this.p3.x = vec3_rotated.getData()[0][0];
        this.p3.y = vec3_rotated.getData()[1][0];
        this.p3.z = vec3_rotated.getData()[2][0];
    }

    // rotates points around arbitrary points
    public void rotate(double deg, double x, double y){
        Matrix rot_mat = new Matrix(3, 3);

        rot_mat = Transform.create_trafo_mat(deg, -x, -y);
        double[][] vecData = {{this.p1.x}, {this.p1.y}, {this.p1.z}};
        Matrix vec1 = new Matrix(vecData);
        Matrix vec1_rotated = rot_mat.times(vec1);
        this.p1.x = vec1_rotated.getData()[0][0];
        this.p1.y = vec1_rotated.getData()[1][0];
        this.p1.z = vec1_rotated.getData()[2][0];

        vecData = new double[][] {{this.p2.x}, {this.p2.y}, {this.p2.z}};
        Matrix vec2 = new Matrix(vecData);
        Matrix vec2_rotated = rot_mat.times(vec2);
        this.p2.x = vec2_rotated.getData()[0][0];
        this.p2.y = vec2_rotated.getData()[1][0];
        this.p2.z = vec2_rotated.getData()[2][0];

        vecData = new double[][] {{this.p3.x}, {this.p3.y}, {this.p3.z}};
        Matrix vec3 = new Matrix(vecData);
        Matrix vec3_rotated = rot_mat.times(vec3);
        vec3_rotated.show();
        this.p3.x = vec3_rotated.getData()[0][0];
        this.p3.y = vec3_rotated.getData()[1][0];
        this.p3.z = vec3_rotated.getData()[2][0];
    }


    public Boolean isRectangular(){
        Point p1 = this.p1;
        Point p2 = this.p2;
        Point p3 = this.p3;

        double side1 = Math.sqrt(Math.pow(p1.getX()-p2.getX(), 2) + Math.pow(p1.getY()-p2.getY(), 2));
        double side2 = Math.sqrt(Math.pow(p1.getX()-p3.getX(), 2) + Math.pow(p1.getY()-p3.getY(), 2));
        double side3 = Math.sqrt(Math.pow(p2.getX()-p3.getX(), 2) + Math.pow(p2.getY()-p3.getY(), 2));
        if (side1 > side2 && side1 > side3){
            if (Math.abs(side1 - Math.sqrt(Math.pow(side2, 2) + Math.pow(side3, 2))) < 0.0000001){
                return true;
            }
            else return false;
        }
        if (side2 > side1 && side2 > side3){
            if (Math.abs(side2 - Math.sqrt(Math.pow(side1, 2) + Math.pow(side3,2))) <  0.0000001){
                return true;
            }
            else return false;
        }
        if (side3 > side1 && side3 > side1){
            if (Math.abs(side3 - Math.sqrt(Math.pow(side1, 2) + Math.pow(side2, 2))) < 0.0000001){
                return true;
            }
            else return false;
        }
        return false;
    }

    // draws a triangle
    public void draw(GraphicsContext gc){
        gc.strokeLine(p2.getX(), p2.getY(), p3.getX(), p3.getY());
        gc.strokeLine(p1.getX(), p1.getY(), p3.getX(), p3.getY());
        gc.strokeLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());

    }
}
