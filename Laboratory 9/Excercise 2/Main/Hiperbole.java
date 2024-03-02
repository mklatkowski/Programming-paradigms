package Main;

import Point.Point;

import java.awt.*;
import java.util.List;

public class Hiperbole extends Item{

    private int vX;
    private int vY;
    private int param;
    private int thickness;

    public Hiperbole(int vX, int vY, int param, int thickness){
        this.vX = vX;
        this.vY = vY;
        this.param = param;
        this.thickness = thickness;
    }

    public void translate(Point p){
        vX = vX+p.getX();
        vY = vY+p.getY();
    }

    public List<Point> getBoundingBox(){
        return null;
    }

    public void draw(Graphics g){
        for(int i=0; i<1000; i++){
            if(i!=vX)
                g.drawLine(i, (param/(i-vX) + vY), i+thickness, (param/(i-vX) + vY)+thickness);
            System.out.println("robie cos");
        }
    }
}
