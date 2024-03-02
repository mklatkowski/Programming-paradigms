package Main;


import Point.Point;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ConcreteDecorator extends Decorator{

    public ConcreteDecorator(Item toWrap){
        super(toWrap);
    }

    public void draw(Graphics g){
        super.draw(g);
   //     drawBoundingBox(g);
    }

    public void drawBoundingBox(Graphics g){

        g.drawPolygon(new int[]{toWrap.getBoundingBox().get(0).getX(),
                        toWrap.getBoundingBox().get(1).getX(),
                        toWrap.getBoundingBox().get(2).getX(),
                        toWrap.getBoundingBox().get(3).getX()},
                       new int[]{toWrap.getBoundingBox().get(0).getY(),
                               toWrap.getBoundingBox().get(1).getY(),
                               toWrap.getBoundingBox().get(2).getY(),
                               toWrap.getBoundingBox().get(3).getY()}, 4);
    }

    public void translate(Point p){
        toWrap.translate(p);
    }

    public List<Point> getBoundingBox(){
        return toWrap.getBoundingBox();
    }


    public String toString(){
        return toWrap.toString();
    }
}
