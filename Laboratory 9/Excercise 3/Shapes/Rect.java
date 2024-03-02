package Shapes;

import Main.Main;
import Point.Point;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import Main.Scene;


public class Rect extends Shape{

    private int width;
    private int height;

    public Rect(int width, int height, boolean filled, int x, int y){
        super(filled);
        if(width<=0 || height<=0){
            throw new IllegalArgumentException("Wrong values have been declarated");
        }
        this.height = height;
        this.width = width;
        point.setX(x);
        point.setY(y);
    }


    public int getWidth(){
        return width;
    }

    public void translate(Point p){
        point.setX(point.getX()+p.getX());
        point.setY(point.getY()+p.getY());
    }

    public void draw(Graphics g){
        if(filled){
            g.fillRect(point.getX(), point.getY(), width, height);
        }
        else{
            g.drawRect(point.getX(), point.getY(), width, height);
        }
    }
    public List<Point> getBoundingBox(){
        ArrayList<Point> boundingBox = new ArrayList<>();
        boundingBox.add(point);
        boundingBox.add(new Point(point.getX()+width, point.getY()));
        boundingBox.add(new Point(point.getX()+width, point.getY()+height));
        boundingBox.add(new Point(point.getX(), point.getY()+height));
        return boundingBox;
    }

}

