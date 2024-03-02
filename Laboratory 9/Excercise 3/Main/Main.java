package Main;

import Point.Point;
import Segment.Segment;
import Shapes.*;

import java.awt.Canvas;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;


public class Main extends Canvas {
    public static void main(String[] args) {
        Scene scene = new Scene();


        Item item1 = new Segment(new Point(20,20), new Point(80,80));
        Item item2 = new Segment(new Point(50,350), new Point(300,300));
        Item item3 = new TextItem("Tekst", new Point(300,300));
//        Item itemT1 = new Circle(40, true, 100,100);
//        Item itemT2 = new Circle(40, true, 100,180);
//        List<Item> listItem = new ArrayList<>();
//        listItem.add(itemT1);
//        listItem.add(itemT2);
//        Item item4 = new ComplexItem(listItem);
        Item item5 = new Rect(100,50,false, 20,20);
        //Item item6 = new Hiperbole(300,200,2000, 3);
        Item item7 = new Triangle(new Point(0,0), new Point(20,20), new Point(50,100), true);
        //item4.translate(new Point(100,100));

        ConcreteDecorator c1 = new ConcreteDecorator(item5);
        //ConcreteDecorator c2 = new ConcreteDecorator(item6);
        ConcreteDecorator c3 = new ConcreteDecorator(item7);
        ConcreteDecorator c4 = new ConcreteDecorator(item1);
        ConcreteDecorator c5 = new ConcreteDecorator(item2);
        ConcreteDecorator c6 = new ConcreteDecorator(item3);





//        scene.addItem(item1);
//        scene.addItem(item2);
//        scene.addItem(item3);
//        scene.addItem(item4);
//        scene.addItem(item5);
//        scene.addItem(item6);
//        scene.addItem(item7);

        scene.addItem(c1);
        //scene.addItem(c2);
        scene.addItem(c3);
        scene.addItem(c4);
        scene.addItem(c5);
        scene.addItem(c6);
        scene.draw();
    }
}