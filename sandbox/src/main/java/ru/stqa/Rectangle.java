package ru.stqa;

/**
 * Created by User on 15.02.2017.
 */
public class Rectangle {

    public double a;
    public double b;

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;

    }

    public double area() {
        return this.a * this.b;
    }

}
