package Shapes;

import Main.Main;
import Point.Point;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import Main.Scene;

public class Circle extends Shape{

    private int radius;
    public Circle(int radius, boolean filled, int x, int y){
        super(filled);
        if(radius<=0){
            throw new IllegalArgumentException("Wrong radius has been declarated");
        }
        this.radius = radius;
        point.setX(x);
        point.setY(y);
    }


    public int getRadius(){
        return radius;
    }

    public void translate(Point p){
        point.setX(point.getX()+p.getX());
        point.setY(point.getY()+p.getY());
    }

    public void draw(Graphics g){
        if(filled){

            g.fillOval(point.getX(), point.getY(), 2*radius, 2*radius);
        }
        else{
            g.drawOval(point.getX(), point.getY(), 2*radius, 2*radius);
        }
        g.drawPolygon(new int[]{getBoundingBox().get(0).getX(), getBoundingBox().get(1).getX(), getBoundingBox().get(2).getX(), getBoundingBox().get(3).getX()},
                      new int[]{getBoundingBox().get(0).getY(), getBoundingBox().get(1).getY(), getBoundingBox().get(2).getY(), getBoundingBox().get(3).getY()}, 4);
    }
    public List<Point> getBoundingBox(){
        ArrayList<Point> boundingBox = new ArrayList<>();
        boundingBox.add(new Point(point.getX(), point.getY()));
        boundingBox.add(new Point(point.getX()+2*radius, point.getY()));
        boundingBox.add(new Point(point.getX()+2*radius, point.getY()+2*radius));
        boundingBox.add(new Point(point.getX(), point.getY()+2*radius));

        return boundingBox;
    }
}

