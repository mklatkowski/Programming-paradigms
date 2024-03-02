package Shapes;

import Main.Main;
import Point.Point;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import Main.Scene;

public class Triangle extends Shape{

    private Point p1;
    private Point p2;
    private Point p3;

    public Triangle(Point p1, Point p2, Point p3, boolean filled){
        super(filled);
        if(p1.equals(p2) || p1.equals(p3) || p2.equals(p3)){
            throw new IllegalArgumentException("Wrong values have been declarated");
        }
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;

        point = new Point(min(p1.getX(), p2.getX(), p3.getX()), max(p1.getY(), p2.getY(), p3.getY()));
    }


    public Point getP1(){
        return p1;
    }

    public Point getP2(){
        return p2;
    }

    public Point getP3(){
        return p3;
    }

    public void translate(Point p){
        point.setX(point.getX()+p.getX());
        point.setY(point.getY()+p.getY());

        p1.setX(p1.getX()+p.getX());
        p1.setY(p1.getY()+p.getY());

        p2.setX(p2.getX()+p.getX());
        p2.setY(p2.getY()+p.getY());

        p3.setX(p3.getX()+p.getX());
        p3.setY(p3.getY()+p.getY());
    }

    public void draw(Graphics g){
        Polygon pol = new Polygon(new int[]{p1.getX(), p2.getX(), p3.getX()}, new int[]{p1.getY(), p2.getY(), p3.getY()}, 3);
        if(filled){
            g.fillPolygon(pol);
        }
        else {
            g.drawPolygon(pol);
        }
        g.drawPolygon(new int[]{getBoundingBox().get(0).getX(), getBoundingBox().get(1).getX(), getBoundingBox().get(2).getX(), getBoundingBox().get(3).getX()},
                new int[]{getBoundingBox().get(0).getY(), getBoundingBox().get(1).getY(), getBoundingBox().get(2).getY(), getBoundingBox().get(3).getY()}, 4);
    }
    public List<Point> getBoundingBox(){
        ArrayList<Point> boundingBox = new ArrayList<>();
        boundingBox.add(new Point(min(p1.getX(), p2.getX(), p3.getX()), min(p1.getY(), p2.getY(), p3.getY())));
        boundingBox.add(new Point(min(p1.getX(), p2.getX(), p3.getX()), max(p1.getY(), p2.getY(), p3.getY())));
        boundingBox.add(new Point(max(p1.getX(), p2.getX(), p3.getX()), max(p1.getY(), p2.getY(), p3.getY())));
        boundingBox.add(new Point(max(p1.getX(), p2.getX(), p3.getX()), min(p1.getY(), p2.getY(), p3.getY())));
        return boundingBox;
    }


    private int max(int a, int b, int c){
        if(a>b){
            return Math.max(a, c);
        }
        else{
            return Math.max(b, c);
        }
    }

    private int min(int a, int b, int c){
        if(a<b){
            return Math.min(a,c);
        }
        else{
            return Math.min(b,c);
        }
    }
}
