package org;

public class Circle {
    private double radius;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        if(0 > radius)
            return;

        this.radius = radius;
    }

    public Circle(double radius) {
        setRadius(radius);
    }

    public double area() {
        return Math.pow(radius, 2) * Math.PI;
    }

    public double circumference() {
        return Math.PI * radius;
    }

    public void printParams() {
        System.out.printf("Radius: %10.5f, Area: %12.5f, Circumference: %10.5f\n", getRadius(), area(), circumference());
    }
}