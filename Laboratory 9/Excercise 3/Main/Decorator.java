package Main;

import java.awt.*;

public abstract class Decorator extends Item{

    protected Item toWrap;

    public Decorator(Item toWrap) {
        this.toWrap = toWrap;
    }

    public void draw(Graphics g){
        toWrap.draw(g);
    }
}

