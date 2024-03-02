package Main;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Scene extends Canvas{


    final private List<Item> items;
    final private JFrame fr;

    public Scene(){
        items = new ArrayList<>();
        fr = new JFrame("Scene");
    }

    public void draw(){

        Canvas canvas = this;
        canvas.setSize(400, 400);

        fr.add(canvas);
        fr.pack();
        fr.setVisible(true);
    }

    public void paint(Graphics g) {
        for (Item item : items) {
            item.draw(g);
        }
    }

    public void addItem(Item item){
        items.add(item);
    }

}
