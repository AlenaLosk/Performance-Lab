package task2;

import java.awt.geom.Point2D;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            Circle circle = readCircleParameters(args[0]);
            ArrayList<Point2D.Float> points = readPoints(args[1]);
            printPointsPosition(circle, points);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Circle readCircleParameters(String fileName) throws Exception {
        float[] array = new float[3];
        try {
            Scanner scanner = new Scanner(new File(fileName));
            int i = 0;
            while (scanner.hasNextLine()) {
                array[i] = scanner.nextFloat();
                i++;
            }
            if (i != 3) {
                throw new Exception("Incorrect count of arguments!");
            }
            if (array[2] == 0) {
                throw new Exception("Incorrect radius!");
            }
            return new Circle(array[0], array[1], array[2]);
        } catch (NullPointerException | FileNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static ArrayList<Point2D.Float> readPoints(String fileName) throws Exception {
        ArrayList<Point2D.Float> data = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(fileName));
            while (scanner.hasNextLine()) {
                float x;
                float y;
                if (!scanner.hasNextFloat()) {
                    throw new Exception("Incorrect x coordinate");
                } else {
                    x = scanner.nextFloat();
                    if (!scanner.hasNextFloat()) {
                        throw new Exception("Incorrect y coordinate");
                    } else {
                        y = scanner.nextFloat();
                        Point2D.Float point = new Point2D.Float(x, y);
                        data.add(point);
                    }
                }
            }
            return data;
        } catch (NullPointerException | FileNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static int checkPoint(Circle circle, Point2D.Float point) {
        float diffX = point.x - circle.getCenterX();
        float diffY = point.y - circle.getCenterY();
        double distance = Math.sqrt(diffX * diffX + diffY * diffY);
        if (distance == circle.getRadius()) {
            return 0; //точка лежит на окружности
        } else if (distance < circle.getRadius()) {
            return 1; //точка лежит внутри окружности
        } else {
            return 2; //точка лежит снаружи окружности
        }
    }

    public static void printPointsPosition(Circle circle, List<Point2D.Float> points) throws Exception {
        if (circle == null) {
            throw new Exception("Incorrect circle parameters!");
        }
        if (points.isEmpty()) {
            throw new Exception("There are no points for checking!");
        }
        for (Point2D.Float point : points) {
            System.out.println(checkPoint(circle, point));
        }
    }
}
