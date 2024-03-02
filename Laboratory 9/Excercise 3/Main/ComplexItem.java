package Main;

import Point.Point;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ComplexItem extends Item{

    private List<Item> items;

    public ComplexItem(List<Item> items){
        this.items = items;
        point = new Point(0,0);
    }


    public void translate(Point p){
        point.setX(point.getX()+p.getX());
        point.setY(point.getY()+p.getY());

        for(Item it: items){
            it.translate(p);
        }
    }

    public List<Point> getBoundingBox(){

        List<Point> allBoundingPoints = new ArrayList<>();
        for(Item item: items){
            allBoundingPoints.addAll(item.getBoundingBox());
        }
        List<Integer> boundingBoxX = new ArrayList<>();
        List<Integer> boundingBoxY = new ArrayList<>();
        for(Point p: allBoundingPoints){
            boundingBoxX.add(p.getX());
            boundingBoxY.add(p.getY());
        }
        List<Point> toReturn = new ArrayList<>();
        toReturn.add(new Point(max(boundingBoxX), max(boundingBoxY)));
        toReturn.add(new Point(max(boundingBoxX), min(boundingBoxY)));
        toReturn.add(new Point(min(boundingBoxX), min(boundingBoxY)));
        toReturn.add(new Point(min(boundingBoxX), max(boundingBoxY)));

        return toReturn;
    }
    public void draw(Graphics g){
        for(Item it: items){
            it.draw(g);
        }
    }

    private int max(List<Integer> list){
        int max = list.get(0);
        for(Integer it: list){
            if(it>max) {
                max = it;
            }
        }
        return max;
    }

    private int min(List<Integer> list){
        int min = list.get(0);
        for(Integer it: list){
            if(it<min) {
                min = it;
            }
        }
        return min;
    }


}
