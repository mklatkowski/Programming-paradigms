package Main;

import Point.Point;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TextItem extends Item{

    private String text;

    public TextItem(String string, Point point){
        super(point);
        text = string;
    }

    public String getText(){
        return text;
    }


    public void translate(Point p) {
        point.setX(point.getX()+p.getX());
        point.setY(point.getY()+p.getY());
    }

    public List<Point> getBoundingBox(){
        List<Point> toReturn = new ArrayList<>();
        toReturn.add(point);
        toReturn.add(new Point(point.getX()+text.toCharArray().length*7, point.getY()));
        toReturn.add(new Point(point.getX()+text.toCharArray().length*7, point.getY()-15));
        toReturn.add(new Point(point.getX(), point.getY()-15));
        return toReturn;
    }

    public void draw(Graphics g){
        g.drawString(text, point.getX(), point.getY());
    }
}
