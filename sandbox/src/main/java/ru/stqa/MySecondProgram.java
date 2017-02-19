package ru.stqa;

/**
 * Created by User on 17.02.2017.
 */
public class MySecondProgram {
    public static void main(String[] args) {
        Point p1 = new Point(3, 1);
        Point p2 = new Point(1, 1);

        double v1 = distance(p1, p2);
        double v2 = p1.distance(p2);
        System.out.println("Расстояние между точками равно " + v1);
        System.out.println("Расстояние между точками равно " + v2);
    }

    public static double distance(Point p1, Point p2) {
        double dx = p1.x - p2.x;
        double dy = p1.y - p2.y;

        return Math.sqrt(dx * dx + dy * dy);
    }
}
