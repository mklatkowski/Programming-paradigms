package Main;

import Point.Point;
import Segment.Segment;
import Shapes.*;

import java.awt.Canvas;
import java.awt.Graphics;
import javax.swing.JFrame;


public class Main extends Canvas {
    public static void main(String[] args) {
        Scene scene = new Scene();


        Item item1 = new Segment(new Point(20,20), new Point(80,80));
        Item item2 = new Segment(new Point(50,50), new Point(300,60));
        Item item3 = new TextItem("Tekst", new Point(300,300));
        Item item4 = new Circle(40, true, 100,100);
        Item item5 = new Rect(100,50,false, 20,20);
        Item item6 = new Hiperbole(200,200,2000, 3);
        Item item7 = new Triangle(new Point(0,0), new Point(20,20), new Point(50,100), true);


        scene.addItem(item1);
        scene.addItem(item2);
        scene.addItem(item3);
        scene.addItem(item4);
        scene.addItem(item5);
        scene.addItem(item6);
        scene.addItem(item7);
        scene.draw();
    }
}