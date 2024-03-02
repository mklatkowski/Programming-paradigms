package Segment;

import Main.Main;
import Main.Primitive;
import Point.Point;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import Main.Scene;

public class Segment extends Primitive {

    private Point start;
    private Point end;


    public Segment(Point start, Point end) {
        this.start = start;
        this.end = end;
        point = new Point(Math.min(start.getX(), end.getX()), Math.max(start.getY(), end.getY()));
    }

    @Override
    public List<Point> getBoundingBox() {
        if (start.getX() == end.getX() || start.getY() == end.getY()) {
            return null;
        }
        List<Point> boundingBox = new ArrayList<>();
        boundingBox.add(new Point(start.getX(), start.getY()));
        boundingBox.add(new Point(start.getX(), end.getY()));
        boundingBox.add(new Point(end.getX(), end.getY()));
        boundingBox.add(new Point(end.getX(), start.getY()));

        return boundingBox;
    }

    public int getLength() {
        return (int) Math.sqrt((start.getX() - end.getX()) ^ 2 + (start.getY() - end.getY()) ^ 2);
    }

    public void translate(Point p) {
        changePoint(point, p);
        changePoint(start, p);
        changePoint(end, p);
    }

    private void changePoint(Point p1, Point p) {
        p1.setX(p1.getX() + p.getX());
        p1.setY(p1.getY() + p.getY());
    }

    public void draw(Graphics g) {
        g.drawLine(start.getX(), start.getY(), end.getX(), end.getY());
    }

}
