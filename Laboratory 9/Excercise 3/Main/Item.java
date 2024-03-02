package Main;

import Point.Point;

import java.awt.*;
import java.util.List;

public abstract class Item {

    protected Point point;
    public Item(){
        point = new Point();
    }
    public Item(Point point){
        this.point = point;
    }

    public Point getPosition(){
        return point;
    }
    public abstract void translate(Point p);

    public abstract List<Point> getBoundingBox();
    public abstract void draw(Graphics g);

    public String toString(){
        return this.getClass() +" x= " + this.point.getX() + ", y=" + this.point.getY();
    }
}
