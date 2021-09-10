package task2;

import java.awt.geom.Point2D;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        float[] array = readCircleParameters(args[0]);
        ArrayList<Point2D.Float> data = readPoints(args[1]);
        checkAllPoints(array, data);
    }

    public static float[] readCircleParameters(String fileName) {
        float[] array = new float[3];
        try {
            Scanner scanner = new Scanner(new File(fileName));
            int i = 0;
            while (scanner.hasNextFloat()) {
                array[i] = scanner.nextFloat();
                i++;
            }
            if (array[2] == 0) {
                throw new Exception("Incorrect radius");
            }
        } catch (Exception e) {
            array = new float[]{0, 0, 0};
        } finally {
            return array;
        }
    }

    public static ArrayList<Point2D.Float> readPoints(String fileName) {
        ArrayList<Point2D.Float> data = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(fileName));
            while (scanner.hasNextLine()) {
                float x;
                float y;
                if (scanner.hasNextFloat()) {
                    x = scanner.nextFloat();
                    if (scanner.hasNextFloat()) {
                        y = scanner.nextFloat();
                    } else {
                        throw new Exception("Incorrect y coordinate");
                    }
                } else {
                    throw new Exception("Incorrect x coordinate");
                }
                Point2D.Float point = new Point2D.Float(x, y);
                data.add(point);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return data;
        }
    }

    public static void checkAllPoints(float[] circleParameters, ArrayList<Point2D.Float> points) {
        float x2 = circleParameters[0];
        float y2 = circleParameters[1];
        float rad = circleParameters[2];
        for (Point2D.Float point: points) {
            float diffX = point.x - x2;
            float diffY = point.y - y2;
            double distance = Math.sqrt(diffX * diffX + diffY * diffY);
            if (distance == rad) {
                System.out.println(0); //точка лежит на окружности
            } else if (distance < rad) {
                System.out.println(1); //точка лежит внутри окружности
            } else {
                System.out.println(2); //точка лежит снаружи окружности
            }
        }
    }
}
