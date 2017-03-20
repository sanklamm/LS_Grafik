package sample;

/**
 * Created by s on 02/03/17.
 */
public class Draw {
    public double deg = 10;
    public double trans_x = 5;
    public double trans_y = 10;

    public Matrix trafo_mat = new Matrix(3, 3);

    public static Matrix create_trans_mat(double trans_x, double trans_y){
        double data [ ] [ ]  =  { {1, 0, trans_x},
                                  {0, 1, trans_y},
                                  {0, 0, 1} };
        Matrix res = new Matrix(data);
        return res;
    }

    public static Matrix create_rot_mat(double deg){
        double rad = (deg * Math.PI)/180;
        double data [ ] [ ]  =  { {Math.cos(rad), -Math.sin(rad), 0},
                                  {Math.sin(rad), Math.cos(rad), 0},
                                  {0, 0, 1} };
        Matrix res = new Matrix(data);
        return res;
    }

    public static Matrix create_trafo_mat(double deg, double trans_x, double trans_y){

        Matrix trans_mat = new Matrix(3, 3);
        Matrix trans_mat_inv = new Matrix(3, 3);
        Matrix rot_mat = new Matrix(3, 3);
        trans_mat = create_trans_mat(trans_x, trans_y);
        trans_mat_inv = create_trans_mat(-trans_x, -trans_y);
        rot_mat = create_rot_mat(deg);

        Matrix res = new Matrix(3, 3);
        res = trans_mat_inv.times(rot_mat);
        res = res.times(trans_mat);

        return res;
    }
}
