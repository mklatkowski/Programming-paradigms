package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Scene extends Canvas{


    final private List<Item> items;
    private int index = 0;
    final private JFrame fr;
    final private Canvas canvas;

    public Scene(){
        items = new ArrayList<>();
        fr = new JFrame("Scene");
        canvas = this;
    }

    public void draw(){

        canvas.setSize(400, 400);
        fr.add(canvas);
        fr.pack();
        fr.setVisible(true);
    }

    public void paint(Graphics g) {
        JButton jb = new JButton("Pokaż bouding box");
        jb.setBounds(100,400,250,20);
        jb.setVisible(true);
        fr.add(jb);


        String[] itemsName = new String[items.size()];
        for(int i=0; i< items.size(); i++){
            itemsName[i] = items.get(i).toString();
        }
        JComboBox<String> cb = new JComboBox<>(itemsName);
        cb.setBounds(100,430,250,20);
        fr.add(cb);
        fr.setLayout(null);
        fr.setSize(400,500);
        fr.setVisible(true);

        for(int i=0; i<items.size(); i++){
            items.get(i).draw(g);
                if(i==index){
                    ConcreteDecorator cd = new ConcreteDecorator(items.get(i));
                    cd.drawBoundingBox(g);
                }
        }

        jb.addActionListener(e -> {
            index = cb.getSelectedIndex();
            draw();
        });
    }

    public void addItem(Item item){
        items.add(item);
    }

}
